/*
 * GeniusReferralsLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.geniusreferrals.api.models;

import java.util.*;

public class BonusesBuilder {
    //the instance to build
    private Bonuses bonuses;

    /**
     * Default constructor to initialize the instance
     */
    public BonusesBuilder() {
        bonuses = new Bonuses();
    }

    /**
     * The referral's token. Usually the one that completed the purchase, or trigger an event.
     */
    public BonusesBuilder advocateToken(String advocateToken) {
        bonuses.setAdvocateToken(advocateToken);
        return this;
    }

    /**
     * The reference number for this request. Usually the order_id, payment_id, or timestamp.
     */
    public BonusesBuilder reference(String reference) {
        bonuses.setReference(reference);
        return this;
    }

    /**
     * The payment amount the referrals has made. Required for a percentage based campaign.
     */
    public BonusesBuilder paymentAmount(Double paymentAmount) {
        bonuses.setPaymentAmount(paymentAmount);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Bonuses build() {
        return bonuses;
    }
}