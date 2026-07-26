package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WidgetsPackageForm {
    public WidgetsPackageForm() {}

    public WidgetsPackageForm(WidgetsPackage widgetsPackage) {
        this.widgetsPackage = widgetsPackage;
    }

    @JsonProperty("widgets_package")
    public WidgetsPackage widgetsPackage;
}
