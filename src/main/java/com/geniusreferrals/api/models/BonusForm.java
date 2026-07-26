package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BonusForm {
    public BonusForm() {}

    public BonusForm(Bonus bonus) {
        this.bonus = bonus;
    }

    @JsonProperty("bonus")
    public Bonus bonus;
}
