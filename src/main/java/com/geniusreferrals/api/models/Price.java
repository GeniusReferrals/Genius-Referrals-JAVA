package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {
    public Price() {}

    @JsonProperty("currency_code")
    public String currencyCode;

    @JsonProperty("amount")
    public Object amount;
}
