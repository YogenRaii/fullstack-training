package com.tutorials.java.core.inheritance;

public class MyCar extends Car {
    public MyCar(String brand) {
        super(brand);
    }

    // final method can not be overriden
//    @Override
//    public String getBrand() {
//        return "MyCarBrand";
//    }
}
