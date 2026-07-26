package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class VouchersController {
    private final GRClient client;
    public VouchersController(GRClient client) { this.client = client; }

    public String getVouchers(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/vouchers", Map.of("account_slug", accountSlug)), qp);
    }

    public String getVoucher(String accountSlug, String voucherId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("voucher_id", voucherId);
        return client.get(GRClient.path("/accounts/{account_slug}/vouchers/{voucher_id}", params), null);
    }

    public String createVoucher(String accountSlug, Object voucherForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/vouchers", Map.of("account_slug", accountSlug)), null, voucherForm);
    }

    public void patchVoucher(String accountSlug, String voucherId, Object voucherForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("voucher_id", voucherId);
        client.patch(GRClient.path("/accounts/{account_slug}/vouchers/{voucher_id}", params), null, voucherForm);
    }

    public void deleteVoucher(String accountSlug, String voucherId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("voucher_id", voucherId);
        client.delete(GRClient.path("/accounts/{account_slug}/vouchers/{voucher_id}", params), null);
    }

    public String getVoucherDenominations(String accountSlug, String currencyCode) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("currency_code", currencyCode);
        return client.get(GRClient.path("/accounts/{account_slug}/vouchers-denominations/{currency_code}", params), null);
    }
}
