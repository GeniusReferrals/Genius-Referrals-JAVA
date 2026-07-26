package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class BonusesController {
    private final GRClient client;
    public BonusesController(GRClient client) { this.client = client; }

    public String getBonuses(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/bonuses", Map.of("account_slug", accountSlug)), qp);
    }

    public String getBonus(String accountSlug, String bonusId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("bonus_id", bonusId);
        return client.get(GRClient.path("/accounts/{account_slug}/bonuses/{bonus_id}", params), null);
    }

    public String postBonus(String accountSlug, Object bonusesForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/bonuses", Map.of("account_slug", accountSlug)), null, bonusesForm);
    }

    public String forceBonus(String accountSlug, Object forceBonusesForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/bonuses/force", Map.of("account_slug", accountSlug)), null, forceBonusesForm);
    }

    public void deleteBonus(String accountSlug, String bonusId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("bonus_id", bonusId);
        client.delete(GRClient.path("/accounts/{account_slug}/bonuses/{bonus_id}", params), null);
    }

    public String checkupBonuses(String accountSlug) throws APIException {
        return client.get(GRClient.path("/accounts/{account_slug}/bonuses/checkup", Map.of("account_slug", accountSlug)), null);
    }

    public String getBonusTraces(String accountSlug) throws APIException {
        return client.get(GRClient.path("/accounts/{account_slug}/bonuses/traces", Map.of("account_slug", accountSlug)), null);
    }

    public String getBonusTrace(String accountSlug, String traceId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("trace_id", traceId);
        return client.get(GRClient.path("/accounts/{account_slug}/bonuses/traces/{trace_id}", params), null);
    }

    public void patchBonus(String accountSlug, String bonusId, Object bonusPatchForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("bonus_id", bonusId);
        client.patch(GRClient.path("/accounts/{account_slug}/bonuses/{bonus_id}", params), null, bonusPatchForm);
    }

    public String getBonusTags(String accountSlug, String bonusId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("bonus_id", bonusId);
        return client.get(GRClient.path("/accounts/{account_slug}/bonuses/{bonus_id}/tags", params), null);
    }

    public String addBonusTag(String accountSlug, String bonusId, Object tagForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("bonus_id", bonusId);
        return client.post(GRClient.path("/accounts/{account_slug}/bonuses/{bonus_id}/tags", params), null, tagForm);
    }

    public void removeBonusTag(String accountSlug, String bonusId, String tagSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("bonus_id", bonusId);
        params.put("tag_slug", tagSlug);
        client.delete(GRClient.path("/accounts/{account_slug}/bonuses/{bonus_id}/tags/{tag_slug}", params), null);
    }
}
