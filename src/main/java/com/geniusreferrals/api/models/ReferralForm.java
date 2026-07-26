package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReferralForm {
    public ReferralForm() {}

    public ReferralForm(Referral referral) {
        this.referral = referral;
    }

    @JsonProperty("referral")
    public Referral referral;
}
