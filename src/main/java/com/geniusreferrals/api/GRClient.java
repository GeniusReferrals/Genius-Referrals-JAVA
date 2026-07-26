package com.geniusreferrals.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.geniusreferrals.api.exceptions.APIException;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

public class GRClient {
    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final HttpClient httpClient;
    private final String baseUri;
    private final String apiToken;
    private final String contentType;

    public GRClient(String apiToken) {
        this(apiToken, Configuration.getBaseUri(), Configuration.getContentType());
    }

    public GRClient(String apiToken, String baseUri, String contentType) {
        this.apiToken = apiToken;
        this.baseUri = baseUri;
        this.contentType = contentType;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    public ObjectMapper getMapper() { return mapper; }

    public String getBaseUri() { return baseUri; }

    // ── GET ──
    public String get(String path, Map<String, Object> queryParams) throws APIException {
        return request("GET", path, queryParams, null);
    }

    public <T> T get(String path, Map<String, Object> queryParams, Class<T> type) throws APIException {
        return parse(get(path, queryParams), type);
    }

    // ── POST ──
    public String post(String path, Map<String, Object> queryParams, Object body) throws APIException {
        return request("POST", path, queryParams, body);
    }

    public <T> T post(String path, Map<String, Object> queryParams, Object body, Class<T> type) throws APIException {
        return parse(post(path, queryParams, body), type);
    }

    // ── PUT ──
    public String put(String path, Map<String, Object> queryParams, Object body) throws APIException {
        return request("PUT", path, queryParams, body);
    }

    public <T> T put(String path, Map<String, Object> queryParams, Object body, Class<T> type) throws APIException {
        return parse(put(path, queryParams, body), type);
    }

    // ── PATCH ──
    public String patch(String path, Map<String, Object> queryParams, Object body) throws APIException {
        return request("PATCH", path, queryParams, body);
    }

    public <T> T patch(String path, Map<String, Object> queryParams, Object body, Class<T> type) throws APIException {
        return parse(patch(path, queryParams, body), type);
    }

    // ── DELETE ──
    public String delete(String path, Map<String, Object> queryParams) throws APIException {
        return request("DELETE", path, queryParams, null);
    }

    public String delete(String path, Map<String, Object> queryParams, Object body) throws APIException {
        return request("DELETE", path, queryParams, body);
    }

    // ── Core request ──
    private String request(String method, String path, Map<String, Object> queryParams, Object body) throws APIException {
        String url = buildUrl(path, queryParams);

        HttpRequest.Builder reqBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(30))
                .header("Accept", "application/json")
                .header("Content-Type", contentType)
                .header("X-Auth-Token", apiToken);

        String bodyJson = null;
        if (body != null) {
            try {
                bodyJson = mapper.writeValueAsString(body);
            } catch (Exception e) {
                throw new APIException("Failed to serialize body: " + e.getMessage());
            }
        }

        String m = method.toUpperCase();
        switch (m) {
            case "GET" -> reqBuilder.GET();
            case "POST" -> reqBuilder.POST(HttpRequest.BodyPublishers.ofString(bodyJson != null ? bodyJson : "", StandardCharsets.UTF_8));
            case "PUT" -> reqBuilder.PUT(HttpRequest.BodyPublishers.ofString(bodyJson != null ? bodyJson : "", StandardCharsets.UTF_8));
            case "DELETE" -> {
                if (bodyJson != null) {
                    reqBuilder.method("DELETE", HttpRequest.BodyPublishers.ofString(bodyJson, StandardCharsets.UTF_8));
                } else {
                    reqBuilder.DELETE();
                }
            }
            case "PATCH" -> reqBuilder.method("PATCH", HttpRequest.BodyPublishers.ofString(bodyJson != null ? bodyJson : "", StandardCharsets.UTF_8));
            default -> throw new APIException("Unsupported HTTP method: " + m);
        }

        try {
            HttpResponse<String> response = httpClient.send(reqBuilder.build(), HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            int code = response.statusCode();
            String resBody = response.body();

            if (code == 401) throw new APIException("You are not authenticated", code, resBody);
            if (code == 403) throw new APIException("User not authorized to perform the operation", code, resBody);
            if (code == 404) throw new APIException("Resource not found", code, resBody);
            if (code < 200 || code > 208) throw new APIException("HTTP Response Not OK: " + code, code, resBody);

            return resBody;
        } catch (APIException e) {
            throw e;
        } catch (Exception e) {
            throw new APIException("Request failed: " + e.getMessage());
        }
    }

    private String buildUrl(String path, Map<String, Object> queryParams) {
        StringBuilder url = new StringBuilder(baseUri);
        if (!path.startsWith("/")) url.append("/");
        url.append(path);

        if (queryParams != null && !queryParams.isEmpty()) {
            StringBuilder qs = new StringBuilder();
            for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
                if (entry.getValue() == null) continue;
                if (qs.length() > 0) qs.append("&");
                qs.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
                qs.append("=");
                qs.append(URLEncoder.encode(String.valueOf(entry.getValue()), StandardCharsets.UTF_8));
            }
            if (qs.length() > 0) {
                url.append("?").append(qs);
            }
        }
        return url.toString();
    }

    @SuppressWarnings("unchecked")
    private <T> T parse(String json, Class<T> type) {
        if (json == null || json.isEmpty()) return null;
        try {
            if (type == String.class) return (T) json;
            return mapper.readValue(json, type);
        } catch (Exception e) {
            throw new APIException("Failed to parse response: " + e.getMessage());
        }
    }

    // ── Path builder helper ──
    public static String path(String template, Map<String, String> params) {
        String result = template;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result = result.replace("{" + entry.getKey() + "}", URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        return result;
    }
}
