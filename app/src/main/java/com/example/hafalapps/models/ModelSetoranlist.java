package com.example.hafalapps.models;

public class ModelSetoranlist {
    String id; //we will need this id to get chat list, sender/receiver uid

    public ModelSetoranlist(String id) {
        this.id = id;
    }

    public ModelSetoranlist() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
