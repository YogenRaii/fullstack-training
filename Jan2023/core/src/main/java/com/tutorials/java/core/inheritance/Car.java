package com.tutorials.java.core.inheritance;

public class Car extends Vehicle {
    private final String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public final String getBrand() {
        // final variable can not be re-initialized
//        this.brand = "newBrand";
        return brand;
    }
}
