package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class AccountsController {
    private final GRClient client;
    public AccountsController(GRClient client) { this.client = client; }

    public String getAccounts(int page, int limit, String format) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        qp.put("format", format);
        return client.get("/accounts", qp);
    }

    public String getAccount(String accountSlug) throws APIException {
        return client.get(GRClient.path("/accounts/{account_slug}", Map.of("account_slug", accountSlug)), null);
    }

    public String createAccount(Object accountForm) throws APIException {
        return client.post("/accounts", null, accountForm);
    }

    public String updateAccount(String accountSlug, Object accountForm) throws APIException {
        return client.put(GRClient.path("/accounts/{account_slug}", Map.of("account_slug", accountSlug)), null, accountForm);
    }

    public void deleteAccount(String accountSlug) throws APIException {
        client.delete(GRClient.path("/accounts/{account_slug}", Map.of("account_slug", accountSlug)), null);
    }
}
