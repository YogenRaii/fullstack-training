package com.vastika.training.java.inheritance.basic;

public class Car extends FourWheeler {
    private String brand;

    /**
     * Argument Constructor
     * @param brand
     */
    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public int getEngineType() {
        return 6;
    }
}
