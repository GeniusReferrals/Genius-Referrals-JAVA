package com.geniusreferrals.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountForm {
    public AccountForm() {}

    public AccountForm(Account account) {
        this.account = account;
    }

    @JsonProperty("account")
    public Account account;
}
