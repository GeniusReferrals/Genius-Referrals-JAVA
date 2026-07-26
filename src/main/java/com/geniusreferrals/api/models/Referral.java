package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Referral {
    public Referral() {}

    @JsonProperty("referred_advocate_token")
    public String referredAdvocateToken;

    @JsonProperty("referral_origin_slug")
    public String referralOriginSlug;

    @JsonProperty("campaign_slug")
    public String campaignSlug;

    @JsonProperty("http_referer")
    public String httpReferer;
}
