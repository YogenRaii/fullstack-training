package com.vastika.training.java.polymorphism.overloading;

/**
 * Static polymorphism / method overloading -> use of same method signature differing in num and type of parameters
 */
public class Printer {
    public void print(String name) {
        System.out.println("Name: " + name);
    }

    /**
     * different no params
     * @param name
     * @param age
     */
    public void print(String name, int age) {
        System.out.println("Name: " + name + ", age: " + age);
    }

    /**
     * same number but different type
     * @param name
     * @param address
     */
    public void print(String name, String address) {
        System.out.println("Name: " + name + ", address: " + address);
    }

    public void print(String name, String address, String relatives) {
        System.out.println("Name: " + name +", address: " + address + ", " + relatives);
    }
}
