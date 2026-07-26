package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForceBonusesForm {
    public ForceBonusesForm() {}

    public ForceBonusesForm(ForceBonuses bonus) {
        this.bonus = bonus;
    }

    @JsonProperty("bonus")
    public ForceBonuses bonus;
}
