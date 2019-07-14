package com.vastika.training.java.polymorphism.basics;

public class Circle implements GeometricShape {
    private int radius;

    public Circle() {
        this(0);
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Invalid Radius");
        }
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
