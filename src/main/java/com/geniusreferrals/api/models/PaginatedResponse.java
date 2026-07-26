package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginatedResponse {
    public PaginatedResponse() {}

    @JsonProperty("page")
    public Integer page;

    @JsonProperty("limit")
    public Integer limit;

    @JsonProperty("total")
    public Integer total;

    @JsonProperty("results")
    public Object results;
}
