package com.vastika.training.java.inheritance.basic;

/**
 * final class -> class that can't be extended
 * final field -> field/reference/variable which can't be re-assigned new value
 * final method -> method can't be overridden
 */
public final class Car extends FourWheeler {
    private final String brand;

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

/*    @Override
    public void honk() {  // final method can't be overridden
        System.out.println("....");
    }*/
}
