package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class AdvocatesController {
    private final GRClient client;
    public AdvocatesController(GRClient client) { this.client = client; }

    public String getAdvocates(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/advocates", Map.of("account_slug", accountSlug)), qp);
    }

    public String getAdvocate(String accountSlug, String advocateToken) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        return client.get(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}", params), null);
    }

    public String postAdvocate(String accountSlug, Object advocateForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/advocates", Map.of("account_slug", accountSlug)), null, advocateForm);
    }

    public String putAdvocate(String accountSlug, String advocateToken, Object advocateForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        return client.put(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}", params), null, advocateForm);
    }

    public void patchAdvocate(String accountSlug, String advocateToken, Object advocatePatchForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        client.patch(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}", params), null, advocatePatchForm);
    }

    public void deleteAdvocate(String accountSlug, String advocateToken) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        client.delete(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}", params), null);
    }

    public void deleteAdvocates(String accountSlug, String advocates) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("advocates", advocates);
        client.delete(GRClient.path("/accounts/{account_slug}/advocates", Map.of("account_slug", accountSlug)), qp);
    }

    public String getAdvocateShareLinks(String accountSlug, String advocateToken) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        return client.get(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/share-links", params), null);
    }

    public String getAdvocatePaymentMethods(String accountSlug, String advocateToken) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        return client.get(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/payment-methods", params), null);
    }

    public String getAdvocatePaymentMethod(String accountSlug, String advocateToken, String paymentMethodId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        params.put("advocate_payment_method_id", paymentMethodId);
        return client.get(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/payment-methods/{advocate_payment_method_id}", params), null);
    }

    public String postAdvocatePaymentMethod(String accountSlug, String advocateToken, Object paymentMethodForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        return client.post(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/payment-methods", params), null, paymentMethodForm);
    }

    public void putAdvocatePaymentMethod(String accountSlug, String advocateToken, String paymentMethodId, Object paymentMethodForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        params.put("advocate_payment_method_id", paymentMethodId);
        client.put(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/payment-methods/{advocate_payment_method_id}", params), null, paymentMethodForm);
    }
}
