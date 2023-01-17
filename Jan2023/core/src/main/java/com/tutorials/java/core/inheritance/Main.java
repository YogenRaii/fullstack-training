package com.tutorials.java.core.inheritance;


// final variable can not be re-initialized
// final class can not be extended
// final method can not be overridden

public class Main {
    public static void main(String[] args) {
//        Vehicle vehicle = new Vehicle(); // abstract class can not be instantiated

        Car hondaCar1 = new Car("Honda");

        Bike pulsar = new Bike("Bajaj");

        System.out.println(hondaCar1.getBrand());
        System.out.println(hondaCar1.getEngineNumber());

        System.out.println(pulsar.getBrand());
        System.out.println(pulsar.getEngineNumber());
    }
}
