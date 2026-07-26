package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Widget {
    public Widget() {}

    @JsonProperty("name")
    public String name;

    @JsonProperty("slug")
    public String slug;

    @JsonProperty("type")
    public String type;

    @JsonProperty("content")
    public String content;
}
