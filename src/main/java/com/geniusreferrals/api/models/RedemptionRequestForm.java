package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RedemptionRequestForm {
    public RedemptionRequestForm() {}

    public RedemptionRequestForm(RedemptionRequest redemptionRequest) {
        this.redemptionRequest = redemptionRequest;
    }

    @JsonProperty("redemption_request")
    public RedemptionRequest redemptionRequest;
}
