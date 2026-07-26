package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Advocate {
    public Advocate() {}

    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("name")
    public String name;

    @JsonProperty("lastname")
    public String lastname;

    @JsonProperty("email")
    public String email;

    @JsonProperty("payout_threshold")
    public Integer payoutThreshold;

    @JsonProperty("avatar_url")
    public String avatarUrl;

    @JsonProperty("metadata")
    public Object metadata;

    @JsonProperty("can_refer")
    public Boolean canRefer;

    @JsonProperty("currency_code")
    public String currencyCode;

    @JsonProperty("status")
    public String status;

    @JsonProperty("fraudulent")
    public Boolean fraudulent;

    @JsonProperty("fraud_detected_by")
    public String fraudDetectedBy;

    @JsonProperty("fraud_rule")
    public String fraudRule;
}
