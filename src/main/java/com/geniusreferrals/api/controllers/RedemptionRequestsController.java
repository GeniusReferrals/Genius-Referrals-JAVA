package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class RedemptionRequestsController {
    private final GRClient client;
    public RedemptionRequestsController(GRClient client) { this.client = client; }

    public String getRedemptionRequests(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/redemption-requests", Map.of("account_slug", accountSlug)), qp);
    }

    public String getRedemptionRequest(String accountSlug, String redemptionRequestId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("redemption_request_id", redemptionRequestId);
        return client.get(GRClient.path("/accounts/{account_slug}/redemption-requests/{redemption_request_id}", params), null);
    }

    public String postRedemptionRequest(String accountSlug, Object redemptionRequestForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/redemption-requests", Map.of("account_slug", accountSlug)), null, redemptionRequestForm);
    }

    public void patchRedemptionRequest(String accountSlug, String redemptionRequestId, Object redemptionRequestForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("redemption_request_id", redemptionRequestId);
        client.patch(GRClient.path("/accounts/{account_slug}/redemption-requests/{redemption_request_id}", params), null, redemptionRequestForm);
    }

    public void redeemRedemptionRequest(String accountSlug, String redemptionRequestId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("redemption_request_id", redemptionRequestId);
        client.patch(GRClient.path("/accounts/{account_slug}/redemption-requests/{redemption_request_id}/redemption", params), null, null);
    }
}
