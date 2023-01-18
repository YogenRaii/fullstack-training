package com.tutorials.java.core.collections;

import java.util.*;

public class Sets {
    // references -> object types/classes
    // primitives -> goes stack -> boolean, byte, char, int, long, float, double
    // wrapper -> references types of primitive types -> Boolean, Byte, Character, Integer
    public static void main(String[] args) {
        Set<Integer> evens = new HashSet<>();
        evens.add(2);
        evens.add(4);
        evens.add(6);
        evens.add(2);

        System.out.println(evens);

        Set<Integer> orderedEven = new LinkedHashSet<>();
        orderedEven.add(2);
        orderedEven.add(8);
        orderedEven.add(6);
        orderedEven.add(8);
        orderedEven.add(6);
        System.out.println(orderedEven);

    }
}
