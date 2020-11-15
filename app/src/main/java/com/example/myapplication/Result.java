package com.example.myapplication;

import java.util.ArrayList;

public class Result <T>{
    private int count;
    private String next;
    private ArrayList<T> results;
    public  ArrayList<T> getResults(){
        return results;
    }
    public int getCount() {
        return count;
    }
    public String getNext() {
        return next;
    }
}
