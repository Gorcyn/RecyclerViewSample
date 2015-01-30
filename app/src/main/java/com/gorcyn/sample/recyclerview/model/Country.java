package com.gorcyn.sample.recyclerview.model;

import java.util.LinkedList;
import java.util.List;

public class Country {

    private String name;
    private List<String> cities = new LinkedList<>();

    public String getName() {
        return name;
    }

    public List<String> getCities() {
        return cities;
    }

    public void addCity(String city) {
        this.cities.add(city);
    }

    public Country(String name) {
        this.name = name;
    }
}
