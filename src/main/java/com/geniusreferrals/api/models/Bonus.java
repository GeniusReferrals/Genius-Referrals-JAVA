package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bonus {
    public Bonus() {}

    @JsonProperty("advocate_token")
    public String advocateToken;

    @JsonProperty("reference")
    public String reference;

    @JsonProperty("payment_amount")
    public Double paymentAmount;

    @JsonProperty("bonus_amount")
    public Double bonusAmount;

    @JsonProperty("currency_code")
    public String currencyCode;

    @JsonProperty("status")
    public String status;
}
