package com.vastika.training.java.inheritance.basic;

/**
 * 1. Download Intellij IDEA Community Edition
 * 2. Either create a project and structure like we did in session or clone the project
 * 3. w3school.com java basics recall
 */
public class DriverClass {
    public static void main(String[] args) {
        Car hondaCar = new Car("Honda");
        // calls method on Car
        System.out.println(hondaCar.getBrand());
        // calls method on FourWheeler
        System.out.println(hondaCar.getEngineType());
        // calls method on Vehicle
        hondaCar.honk();

    }
}
