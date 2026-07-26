package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceForm {
    public PriceForm() {}

    public PriceForm(Price price) {
        this.price = price;
    }

    @JsonProperty("price")
    public Price price;
}
