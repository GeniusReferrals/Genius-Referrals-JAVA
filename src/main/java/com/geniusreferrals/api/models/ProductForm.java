package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductForm {
    public ProductForm() {}

    public ProductForm(Product product) {
        this.product = product;
    }

    @JsonProperty("product")
    public Product product;
}
