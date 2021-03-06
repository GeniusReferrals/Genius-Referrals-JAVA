/*
 * GeniusReferralsLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.geniusreferrals.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class PaymentMethodForm 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5676628543086487130L;
    private PaymentMethod advocatePaymentMethod;
    /** GETTER
     * The payment methods wrapper
     */
    @JsonGetter("advocate_payment_method")
    public PaymentMethod getAdvocatePaymentMethod ( ) { 
        return this.advocatePaymentMethod;
    }
    
    /** SETTER
     * The payment methods wrapper
     */
    @JsonSetter("advocate_payment_method")
    public void setAdvocatePaymentMethod (PaymentMethod value) { 
        this.advocatePaymentMethod = value;
    }
 
}
 