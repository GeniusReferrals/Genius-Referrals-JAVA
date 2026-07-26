package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WidgetForm {
    public WidgetForm() {}

    public WidgetForm(Widget widget) {
        this.widget = widget;
    }

    @JsonProperty("widget")
    public Widget widget;
}
