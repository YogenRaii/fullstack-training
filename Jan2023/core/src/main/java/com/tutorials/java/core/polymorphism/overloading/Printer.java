package com.tutorials.java.core.polymorphism.overloading;

public class Printer {
    // method overloading
    // same method name
    // differs in type and number of arguments
    public void print(String msg) {
        System.out.println(msg);
    }

    public void print(String msg, int age) {
        System.out.println(msg + " with age " + age);
    }

    public void print(String msg, int age, boolean validity) {
        System.out.println(String.format("%s with age %d and validity %b", msg, age, validity));
    }
}
