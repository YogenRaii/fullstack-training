package com.tutorials.java.core.inheritance;

public final class Bike extends Vehicle {
    private String brand;

    public Bike(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public int getEngineNumber() {
        return 2;
    }
}
