package com.tutorials.java.core.polymorphism.dynamic;

public class Rectangle implements GeometricShape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + breadth);
    }
}
