package com.example.firebaseurl;

import android.util.Log;

import java.util.List;

public class City {
    private String name;
    private String id;
    private String idu;
    private String state;
    private String country;
    private boolean capital;
    private long population;
    private List<String> regions;

    public City() {}

    public City (String name,String state, String country, boolean capital, long population, List<String> regions) {

        this.name=name;
        this.regions=regions;
        Log.d("demo1", name + state);
    }

    public String getName() {
        return name;
    }

//    public String getIdu() {
//        return idu;
//    }
//
    public String getId() {
        return id;
    }


    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public boolean isCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public List<String> getRegions() {
        return regions;
    }
}
