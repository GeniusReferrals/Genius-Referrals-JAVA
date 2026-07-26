package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Voucher {
    public Voucher() {}

    @JsonProperty("code")
    public String code;

    @JsonProperty("value")
    public Double value;

    @JsonProperty("currency_code")
    public String currencyCode;

    @JsonProperty("status")
    public String status;
}
