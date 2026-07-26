package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RedemptionRequest {
    public RedemptionRequest() {}

    @JsonProperty("advocate_token")
    public String advocateToken;

    @JsonProperty("request_status_slug")
    public String requestStatusSlug;

    @JsonProperty("request_action_slug")
    public String requestActionSlug;

    @JsonProperty("currency_code")
    public String currencyCode;

    @JsonProperty("amount")
    public Double amount;

    @JsonProperty("description")
    public String description;

    @JsonProperty("advocates_paypal_username")
    public String advocatesPaypalUsername;

    @JsonProperty("payment_method_slug")
    public String paymentMethodSlug;

    @JsonProperty("internal_note")
    public String internalNote;

    @JsonProperty("modified_by")
    public String modifiedBy;

    @JsonProperty("schemaless_config")
    public Object schemalessConfig;
}
