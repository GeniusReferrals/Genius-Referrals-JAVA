package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag {
    public Tag() {}

    @JsonProperty("name")
    public String name;

    @JsonProperty("slug")
    public String slug;

    @JsonProperty("description")
    public String description;

    @JsonProperty("color")
    public String color;
}
