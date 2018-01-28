package com.crocodile.myapplication;

import android.content.Context;

import com.crocodile.myapplication.model.Country;

import java.util.HashMap;

/**
 * Created by ekaterinachubarova on 22.08.16.
 */
public class CountryLab {

    private static final String FILENAME = "countries.json";

    private static CountryLab countryLab;
    private HashMap<Integer, Country> countries;
    private CountryJSONSerializer countryJSONSerializer;

    private CountryLab(Context context) {
        countryJSONSerializer = new CountryJSONSerializer(context, FILENAME);
        try {
            countries = countryJSONSerializer.loadCountries();
        } catch (Exception e) {

        }
    }

    public boolean saveCountries () {
        try {
            countryJSONSerializer.saveCountries(countries);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static CountryLab get (Context context){
        if (countryLab == null) {
            countryLab = new CountryLab(context);
        } return countryLab;
    }

    public HashMap<Integer, Country> getCountries (){
        return countries;
    }

    public Country getCountry (int id){
        return countries.get(id);
    }

    public void updateCountry(int index, Country country){
        countries.put(index, country);
        saveCountries();
    }
}
