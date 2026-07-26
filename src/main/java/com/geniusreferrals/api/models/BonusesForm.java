package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BonusesForm {
    public BonusesForm() {}

    public BonusesForm(Bonuses bonus) {
        this.bonus = bonus;
    }

    @JsonProperty("bonus")
    public Bonuses bonus;
}
