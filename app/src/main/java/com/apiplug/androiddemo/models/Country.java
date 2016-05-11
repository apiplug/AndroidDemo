package com.apiplug.androiddemo.models;

/**
 * Country Model
 * @author APIPlug
 * @version v1.0
 *
 */
public class Country {

    //Variables in our Country JSON result from API
    private int country_id;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }



}