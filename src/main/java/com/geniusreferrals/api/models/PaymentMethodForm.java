package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethodForm {
    public PaymentMethodForm() {}

    public PaymentMethodForm(PaymentMethod advocatePaymentMethod) {
        this.advocatePaymentMethod = advocatePaymentMethod;
    }

    @JsonProperty("advocate_payment_method")
    public PaymentMethod advocatePaymentMethod;
}
