package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProcessRedemptionForm {
    public ProcessRedemptionForm() {}

    @JsonProperty("request_action_slug")
    public String requestActionSlug;

    @JsonProperty("internal_note")
    public String internalNote;

    @JsonProperty("modified_by")
    public String modifiedBy;
}
