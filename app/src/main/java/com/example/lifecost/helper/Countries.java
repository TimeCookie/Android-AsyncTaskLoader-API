package com.example.lifecost.helper;

import java.util.Locale;

public class Countries {
    private static String[] countries = new String[1000];

    public static String[] getAllCountries() {
        String[] countryCodes = Locale.getISOCountries();
        int counter = 0;
        for(String code: countryCodes) {
            Locale country = new Locale("", code);
            countries[counter] = country.getDisplayCountry();
            counter++;
        }
        return countries;
    }
}
