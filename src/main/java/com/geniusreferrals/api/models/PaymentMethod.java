package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethod {
    public PaymentMethod() {}

    @JsonProperty("username")
    public String username;

    @JsonProperty("description")
    public String description;

    @JsonProperty("is_active")
    public Boolean isActive;

    @JsonProperty("payment_method_slug")
    public String paymentMethodSlug;
}
