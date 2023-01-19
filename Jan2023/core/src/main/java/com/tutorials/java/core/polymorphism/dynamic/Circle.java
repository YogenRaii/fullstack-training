package com.tutorials.java.core.polymorphism.dynamic;

public class Circle implements GeometricShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
