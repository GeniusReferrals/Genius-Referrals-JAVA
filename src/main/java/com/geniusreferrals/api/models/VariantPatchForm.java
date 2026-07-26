package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VariantPatchForm {
    public VariantPatchForm() {}

    @JsonProperty("title")
    public String title;

    @JsonProperty("sku")
    public String sku;

    @JsonProperty("barcode")
    public String barcode;

    @JsonProperty("inventory_quantity")
    public Integer inventoryQuantity;

    @JsonProperty("features")
    public String features;
}
