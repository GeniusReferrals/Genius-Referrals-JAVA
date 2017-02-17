/*
 * GeniusReferralsLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.geniusreferrals.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Advocate 
        implements java.io.Serializable {
    private static final long serialVersionUID = 4942196142545363613L;
    private String name;
    private String lastname;
    private String email;
    private int payoutThreshold;
    private String avatarUrl;
    private String metadata;
    private Boolean canRefer = true;
    /** GETTER
     * The advocate's name
     */
    @JsonGetter("name")
    public String getName ( ) { 
        return this.name;
    }
    
    /** SETTER
     * The advocate's name
     */
    @JsonSetter("name")
    public void setName (String value) { 
        this.name = value;
    }
 
    /** GETTER
     * The advocate's last name
     */
    @JsonGetter("lastname")
    public String getLastname ( ) { 
        return this.lastname;
    }
    
    /** SETTER
     * The advocate's last name
     */
    @JsonSetter("lastname")
    public void setLastname (String value) { 
        this.lastname = value;
    }
 
    /** GETTER
     * The advocate's email
     */
    @JsonGetter("email")
    public String getEmail ( ) { 
        return this.email;
    }
    
    /** SETTER
     * The advocate's email
     */
    @JsonSetter("email")
    public void setEmail (String value) { 
        this.email = value;
    }
 
    /** GETTER
     * The total amount of bonuses that the advocate must generate before being able to create a bonus redemption request.
     */
    @JsonGetter("payout_threshold")
    public int getPayoutThreshold ( ) { 
        return this.payoutThreshold;
    }
    
    /** SETTER
     * The total amount of bonuses that the advocate must generate before being able to create a bonus redemption request.
     */
    @JsonSetter("payout_threshold")
    public void setPayoutThreshold (int value) { 
        this.payoutThreshold = value;
    }
 
    /** GETTER
     * The advocate's avatar URL
     */
    @JsonGetter("avatar_url")
    public String getAvatarUrl ( ) { 
        return this.avatarUrl;
    }
    
    /** SETTER
     * The advocate's avatar URL
     */
    @JsonSetter("avatar_url")
    public void setAvatarUrl (String value) { 
        this.avatarUrl = value;
    }
 
    /** GETTER
     * Useful to store extra information about the advocate. e.g, the phone number, address, etc.
     */
    @JsonGetter("metadata")
    public String getMetadata ( ) { 
        return this.metadata;
    }
    
    /** SETTER
     * Useful to store extra information about the advocate. e.g, the phone number, address, etc.
     */
    @JsonSetter("metadata")
    public void setMetadata (String value) { 
        this.metadata = value;
    }
 
    /** GETTER
     * Whether or not the advocate is allowed to refer services/products (Useful when using the Full Widget template).
     */
    @JsonGetter("can_refer")
    public Boolean getCanRefer ( ) { 
        return this.canRefer;
    }
    
    /** SETTER
     * Whether or not the advocate is allowed to refer services/products (Useful when using the Full Widget template).
     */
    @JsonSetter("can_refer")
    public void setCanRefer (Boolean value) { 
        this.canRefer = value;
    }
 
}
 