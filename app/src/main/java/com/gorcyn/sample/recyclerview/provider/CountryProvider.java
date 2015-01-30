package com.gorcyn.sample.recyclerview.provider;

import com.gorcyn.sample.recyclerview.model.Country;

import java.util.LinkedList;
import java.util.List;

public class CountryProvider {

    public static List<Country> getCountries() {

        List<Country> countries = new LinkedList<>();

        Country deutschland = new Country("Deutschland");
        deutschland.addCity("Berlin");
        deutschland.addCity("Hamburg");
        deutschland.addCity("München");
        countries.add(deutschland);

        Country england = new Country("England");
        england.addCity("Liverpool");
        england.addCity("London");
        england.addCity("Manchester");
        countries.add(england);

        Country espana = new Country("España");
        espana.addCity("Barcelona");
        espana.addCity("Madrid");
        espana.addCity("Valencia");
        countries.add(espana);

        Country france = new Country("France");
        france.addCity("Bordeaux");
        france.addCity("Lyon");
        france.addCity("Marseille");
        france.addCity("Paris");
        countries.add(france);

        return countries;
    }
}
