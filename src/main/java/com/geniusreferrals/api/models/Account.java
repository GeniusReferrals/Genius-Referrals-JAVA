package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    public Account() {}

    @JsonProperty("name")
    public String name;

    @JsonProperty("url")
    public String url;

    @JsonProperty("slug")
    public String slug;

    @JsonProperty("is_active")
    public Boolean isActive;

    @JsonProperty("is_live")
    public Boolean isLive;
}
