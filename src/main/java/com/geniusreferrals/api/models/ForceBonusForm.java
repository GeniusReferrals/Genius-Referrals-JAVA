package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForceBonusForm {
    public ForceBonusForm() {}

    public ForceBonusForm(ForceBonus bonus) {
        this.bonus = bonus;
    }

    @JsonProperty("bonus")
    public ForceBonus bonus;
}
