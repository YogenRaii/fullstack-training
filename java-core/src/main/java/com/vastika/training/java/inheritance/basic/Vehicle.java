package com.vastika.training.java.inheritance.basic;

import java.util.Objects;

/**
 * Parent class
 *
 * Object can't be instantiated for abstract classes
 */
public abstract class Vehicle {
    public abstract String getBrand();

    protected abstract int getEngineType();

    public void honk() {
        System.out.println("Pip, Pip!");
    }
}
