package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoucherForm {
    public VoucherForm() {}

    public VoucherForm(Voucher voucher) {
        this.voucher = voucher;
    }

    @JsonProperty("voucher")
    public Voucher voucher;
}
