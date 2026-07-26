package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class UtilitiesController {
    private final GRClient client;
    public UtilitiesController(GRClient client) { this.client = client; }

    public String getBonusesRedemptionMethods(int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get("/utilities/bonuses-redemption-methods", qp);
    }

    public String getBonusesRedemptionMethod(String slug) throws APIException {
        return client.get(GRClient.path("/utilities/bonuses-redemption-methods/{bonuses_redemption_method_slug}", Map.of("bonuses_redemption_method_slug", slug)), null);
    }

    public String getCurrencies(int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get("/utilities/currencies", qp);
    }

    public String getCurrency(String code) throws APIException {
        return client.get(GRClient.path("/utilities/currencies/{code}", Map.of("code", code)), null);
    }

    public String getPaymentMethodsList(int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get("/utilities/payment-methods", qp);
    }

    public String getRedemptionRequestActions(int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get("/utilities/redemption-request-actions", qp);
    }

    public String getRedemptionRequestAction(String slug) throws APIException {
        return client.get(GRClient.path("/utilities/redemption-request-actions/{redemption_request_action_slug}", Map.of("redemption_request_action_slug", slug)), null);
    }

    public String getRedemptionRequestStatuses(int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get("/utilities/redemption-request-statuses", qp);
    }

    public String getRedemptionRequestStatus(String slug) throws APIException {
        return client.get(GRClient.path("/utilities/redemption-request-statuses/{redemption_request_status_slug}", Map.of("redemption_request_status_slug", slug)), null);
    }

    public String getReferralOrigins(int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get("/utilities/referral-origins", qp);
    }

    public String getReferralOrigin(String slug) throws APIException {
        return client.get(GRClient.path("/utilities/referral-origins/{referral_origin_slug}", Map.of("referral_origin_slug", slug)), null);
    }
}
