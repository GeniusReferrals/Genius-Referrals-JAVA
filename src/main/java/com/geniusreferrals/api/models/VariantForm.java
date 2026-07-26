package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariantForm {
    public VariantForm() {}

    public VariantForm(Variant variant) {
        this.variant = variant;
    }

    @JsonProperty("variant")
    public Variant variant;
}
