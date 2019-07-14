package com.vastika.training.java.collections.map;

import java.util.HashMap;
import java.util.Map;

public class StudentMap {
    public static void main(String[] args) {
        Map<Integer, String> idName = new HashMap<>();

        idName.put(1, "Dheeraj");
        idName.put(2, "Saurav");
        idName.put(3, "Roshan");

        System.out.println(idName);

        System.out.println(idName.get(1));
        System.out.println(idName.get(3));

        for (Map.Entry<Integer, String> entry: idName.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
