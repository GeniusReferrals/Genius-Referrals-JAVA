package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class TagsController {
    private final GRClient client;
    public TagsController(GRClient client) { this.client = client; }

    public String getTags(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/tags", Map.of("account_slug", accountSlug)), qp);
    }

    public String getTag(String accountSlug, String tagSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("tag_slug", tagSlug);
        return client.get(GRClient.path("/accounts/{account_slug}/tags/{tag_slug}", params), null);
    }

    public String createTag(String accountSlug, Object tagForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/tags", Map.of("account_slug", accountSlug)), null, tagForm);
    }

    public void updateTag(String accountSlug, String tagSlug, Object tagForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("tag_slug", tagSlug);
        client.put(GRClient.path("/accounts/{account_slug}/tags/{tag_slug}", params), null, tagForm);
    }

    public void deleteTag(String accountSlug, String tagSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("tag_slug", tagSlug);
        client.delete(GRClient.path("/accounts/{account_slug}/tags/{tag_slug}", params), null);
    }
}
