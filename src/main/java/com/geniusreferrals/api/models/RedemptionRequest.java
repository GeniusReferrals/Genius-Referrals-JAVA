/*
 * GeniusReferralsLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.geniusreferrals.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RedemptionRequest 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5516660806360380523L;
    private String advocateToken;
    private String requestStatusSlug;
    private String requestActionSlug;
    private String currencyCode;
    private int amount;
    private String description;
    private String advocatesPaypalUsername;
    /** GETTER
     * The advocate's token
     */
    @JsonGetter("advocate_token")
    public String getAdvocateToken ( ) { 
        return this.advocateToken;
    }
    
    /** SETTER
     * The advocate's token
     */
    @JsonSetter("advocate_token")
    public void setAdvocateToken (String value) { 
        this.advocateToken = value;
    }
 
    /** GETTER
     * The request status identifier
     */
    @JsonGetter("request_status_slug")
    public String getRequestStatusSlug ( ) { 
        return this.requestStatusSlug;
    }
    
    /** SETTER
     * The request status identifier
     */
    @JsonSetter("request_status_slug")
    public void setRequestStatusSlug (String value) { 
        this.requestStatusSlug = value;
    }
 
    /** GETTER
     * The request action identifier
     */
    @JsonGetter("request_action_slug")
    public String getRequestActionSlug ( ) { 
        return this.requestActionSlug;
    }
    
    /** SETTER
     * The request action identifier
     */
    @JsonSetter("request_action_slug")
    public void setRequestActionSlug (String value) { 
        this.requestActionSlug = value;
    }
 
    /** GETTER
     * The currency code
     */
    @JsonGetter("currency_code")
    public String getCurrencyCode ( ) { 
        return this.currencyCode;
    }
    
    /** SETTER
     * The currency code
     */
    @JsonSetter("currency_code")
    public void setCurrencyCode (String value) { 
        this.currencyCode = value;
    }
 
    /** GETTER
     * The amount to be redeemed
     */
    @JsonGetter("amount")
    public int getAmount ( ) { 
        return this.amount;
    }
    
    /** SETTER
     * The amount to be redeemed
     */
    @JsonSetter("amount")
    public void setAmount (int value) { 
        this.amount = value;
    }
 
    /** GETTER
     * The description of the requests, useful to store extra information about the request.
     */
    @JsonGetter("description")
    public String getDescription ( ) { 
        return this.description;
    }
    
    /** SETTER
     * The description of the requests, useful to store extra information about the request.
     */
    @JsonSetter("description")
    public void setDescription (String value) { 
        this.description = value;
    }
 
    /** GETTER
     * The advocate's PayPal username
     */
    @JsonGetter("advocates_paypal_username")
    public String getAdvocatesPaypalUsername ( ) { 
        return this.advocatesPaypalUsername;
    }
    
    /** SETTER
     * The advocate's PayPal username
     */
    @JsonSetter("advocates_paypal_username")
    public void setAdvocatesPaypalUsername (String value) { 
        this.advocatesPaypalUsername = value;
    }
 
}
 