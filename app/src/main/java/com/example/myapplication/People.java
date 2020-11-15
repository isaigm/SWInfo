package com.example.myapplication;

import java.util.ArrayList;

public class People {
    private String name;
    private int height;
    transient int mass;
    transient String hair_color;
    transient String skin_color;
    transient String eye_color;
    private String birth_year;
    transient String gender;
    transient String homeworld;
    transient ArrayList<String> films;
    transient ArrayList<String> species;
    transient ArrayList<String> vehicles;
    transient ArrayList<String> starships;
    transient String created;
    transient String edited;
    transient String url;
    public String getName() {
        return name;
    }
    public int getHeight() {
        return height;
    }
    public String getBirth_year() {
        return birth_year;
    }
}
