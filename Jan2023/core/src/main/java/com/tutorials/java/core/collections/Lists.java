package com.tutorials.java.core.collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    // references -> object types/classes
    // primitives -> goes stack -> boolean, byte, char, int, long, float, double
    // wrapper -> references types of primitive types -> Boolean, Byte, Character, Integer
    public static void main(String[] args) {
//        int x = new Integer(4); // unboxing
//        Integer y = 4; // boxing
        List<Integer> evens = new ArrayList<>();
        evens.add(2);
        evens.add(4);
        evens.add(6);
        evens.add(2);

        System.out.println(evens);
    }

}
