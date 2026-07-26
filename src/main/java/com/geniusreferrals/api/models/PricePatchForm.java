package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricePatchForm {
    public PricePatchForm() {}

    @JsonProperty("amount")
    public Object amount;
}
