package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    public Product() {}

    @JsonProperty("title")
    public String title;

    @JsonProperty("slug")
    public String slug;

    @JsonProperty("description_html")
    public String descriptionHtml;

    @JsonProperty("status")
    public String status;

    @JsonProperty("images")
    public List<String> images;
}
