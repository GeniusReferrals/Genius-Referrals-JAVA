package com.geniusreferrals.api;

public final class Configuration {
    private static String baseUri = "https://api.geniusreferrals.com";
    private static String contentType = "application/json";
    private static String apiToken = "";

    private Configuration() {}

    public static String getBaseUri() { return baseUri; }
    public static void setBaseUri(String uri) { baseUri = uri; }

    public static String getContentType() { return contentType; }
    public static void setContentType(String ct) { contentType = ct; }

    public static String getApiToken() { return apiToken; }
    public static void setApiToken(String token) { apiToken = token; }
}
