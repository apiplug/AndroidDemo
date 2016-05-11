package com.apiplug.androiddemo.models;

/**
 * Actor Model
 * @author APIPlug
 * @version v1.0
 *
 */
public class Actor {

    //Variables in our Actor JSON result from API
    private int actor_id;
    private String first_name;
    private String last_name;


    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

}