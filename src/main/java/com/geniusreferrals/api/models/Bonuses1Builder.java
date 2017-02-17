/*
 * GeniusReferralsLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.geniusreferrals.api.models;

import java.util.*;

public class Bonuses1Builder {
    //the instance to build
    private Bonuses1 bonuses1;

    /**
     * Default constructor to initialize the instance
     */
    public Bonuses1Builder() {
        bonuses1 = new Bonuses1();
    }

    /**
     * The referral's token.
     */
    public Bonuses1Builder advocateToken(String advocateToken) {
        bonuses1.setAdvocateToken(advocateToken);
        return this;
    }

    /**
     * The reference number for this request. Usually the order_id, payment_id, or timestamp.
     */
    public Bonuses1Builder reference(String reference) {
        bonuses1.setReference(reference);
        return this;
    }

    /**
     * The bonus amount to give to the advocate.
     */
    public Bonuses1Builder bonusAmount(int bonusAmount) {
        bonuses1.setBonusAmount(bonusAmount);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Bonuses1 build() {
        return bonuses1;
    }
}