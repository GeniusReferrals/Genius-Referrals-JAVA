/*
 * GeniusReferralsLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.geniusreferrals.api.models;

import java.util.*;

public class AdvocateFormBuilder {
    //the instance to build
    private AdvocateForm advocateForm;

    /**
     * Default constructor to initialize the instance
     */
    public AdvocateFormBuilder() {
        advocateForm = new AdvocateForm();
    }

    /**
     * The advocate's wrapper
     */
    public AdvocateFormBuilder advocate(Advocate advocate) {
        advocateForm.setAdvocate(advocate);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public AdvocateForm build() {
        return advocateForm;
    }
}