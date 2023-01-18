package com.tutorials.java.core.collections;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map<String, String> countryCapitol = new HashMap<>();
        countryCapitol.put("Nepal", "KTM");
        countryCapitol.put("USA", "Washington DC");
        countryCapitol.put("India", "Delhi");

        countryCapitol
                .forEach((country, capitol) ->
                        System.out.println(country + " -> " + capitol));

        System.out.println("using for each -> ");
        for (String country: countryCapitol.keySet()) {
            System.out.println(country + " -> " + countryCapitol.get(country));
        }

        // newer features
        var names = Map.of("Yogen", "Rai", "Sachin", "Bala");
        System.out.println(names);
    }
}
