/*
 * GeniusReferralsLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.geniusreferrals.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ForceBonusesForm 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5325698484726266094L;
    private ForceBonuses bonus;
    /** GETTER
     * The bonuses' wrapper
     */
    @JsonGetter("bonus")
    public ForceBonuses getBonus ( ) { 
        return this.bonus;
    }
    
    /** SETTER
     * The bonuses' wrapper
     */
    @JsonSetter("bonus")
    public void setBonus (ForceBonuses value) { 
        this.bonus = value;
    }
 
}
 