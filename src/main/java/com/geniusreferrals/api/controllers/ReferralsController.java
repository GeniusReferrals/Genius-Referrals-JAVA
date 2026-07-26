package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class ReferralsController {
    private final GRClient client;
    public ReferralsController(GRClient client) { this.client = client; }

    public String getReferrals(String accountSlug, String advocateToken, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        Map<String, String> pp = new HashMap<>();
        pp.put("account_slug", accountSlug);
        pp.put("advocate_token", advocateToken);
        return client.get(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/referrals", pp), qp);
    }

    public String getReferral(String accountSlug, String advocateToken, String referralId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        params.put("referral_id", referralId);
        return client.get(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/referrals/{referral_id}", params), null);
    }

    public String postReferral(String accountSlug, String advocateToken, Object referralForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        return client.post(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/referrals", params), null, referralForm);
    }

    public void putReferral(String accountSlug, String advocateToken, String referralId, Object referralForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        params.put("referral_id", referralId);
        client.put(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/referrals/{referral_id}", params), null, referralForm);
    }

    public void deleteReferral(String accountSlug, String advocateToken, String referralId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("advocate_token", advocateToken);
        params.put("referral_id", referralId);
        client.delete(GRClient.path("/accounts/{account_slug}/advocates/{advocate_token}/referrals/{referral_id}", params), null);
    }
}
