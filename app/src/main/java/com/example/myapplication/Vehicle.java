package com.example.myapplication;

import java.util.ArrayList;

public class Vehicle {
    private String name;
    private String model;
    private String manufacturer;
    transient String cost_in_credits;
    transient double length;
    transient int max_atmosphering_speed;
    transient int crew;
    transient int passengers;
    transient int cargo_capacity;
    transient String consumables;
    transient String vehicle_class;
    transient ArrayList<String> pilots;
    transient ArrayList<String> films;
    transient String created;
    transient String edited;
    transient String url;
    public String getName() {
        return name;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
}
