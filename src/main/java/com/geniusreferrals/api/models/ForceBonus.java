package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForceBonus {
    public ForceBonus() {}

    @JsonProperty("advocate_token")
    public String advocateToken;

    @JsonProperty("reference")
    public String reference;

    @JsonProperty("bonus_amount")
    public Double bonusAmount;
}
