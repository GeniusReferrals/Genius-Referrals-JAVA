package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WidgetsPackage {
    public WidgetsPackage() {}

    @JsonProperty("name")
    public String name;

    @JsonProperty("slug")
    public String slug;
}
