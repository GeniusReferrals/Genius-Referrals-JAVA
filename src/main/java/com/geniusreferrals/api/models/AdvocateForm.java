package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvocateForm {
    public AdvocateForm() {}

    public AdvocateForm(Advocate advocate) {
        this.advocate = advocate;
    }

    @JsonProperty("advocate")
    public Advocate advocate;
}
