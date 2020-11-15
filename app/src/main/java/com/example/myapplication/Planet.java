package com.example.myapplication;

import java.util.ArrayList;

public class Planet {
    private String name;
    transient int rotation_period;
    transient int orbital_period;
    private int diameter;
    transient String climate;
    transient String gravity;
    transient String terrain;
    transient int surface_water;
    private String population;
    transient ArrayList<String> residents;
    transient ArrayList<String> films;
    transient String created;
    transient String edited;
    transient String url;
    public String getName() {
        return name;
    }
    public int getDiameter() {
        return diameter;
    }
    public String getPopulation() {
        return population;
    }
}
