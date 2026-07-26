package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class CampaignsController {
    private final GRClient client;
    public CampaignsController(GRClient client) { this.client = client; }

    public String getCampaigns(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/campaigns", Map.of("account_slug", accountSlug)), qp);
    }

    public String getCampaign(String accountSlug, String campaignSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("campaign_slug", campaignSlug);
        return client.get(GRClient.path("/accounts/{account_slug}/campaigns/{campaign_slug}", params), null);
    }
}
