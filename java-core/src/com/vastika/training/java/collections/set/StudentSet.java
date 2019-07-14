package com.vastika.training.java.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentSet {
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        for (int n = 1; n <= 10; n++) {
            integers.add(n);
        }

        System.out.println(integers); // [1..10]
        integers.add(2);
        integers.add(10);
        integers.add(2);
        integers.add(11);

        System.out.println(integers); // [1..11]
/*
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) % 2 == 0) {
                System.out.println(integers.get(i));
            }
        }*/
        Set<String> names = new HashSet<>();
        names.add("dheeraj");
        names.add("saurav");
        names.add("rosan");
        names.add("rosan");
        names.add("saurav");
        System.out.println(names);
    }
}
