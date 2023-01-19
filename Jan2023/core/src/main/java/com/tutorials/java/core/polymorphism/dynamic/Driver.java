package com.tutorials.java.core.polymorphism.dynamic;

import java.util.List;

public class Driver {
    // Dynamic polymorphism -> one object can have multiple form ie. can be referenced
    // by at least of two types -> 1. itself 2. Object class
    public static void main(String[] args) {
        GeometricShape circle = new Circle(2);
        GeometricShape square = new Square(3);
        GeometricShape rectangle = new Rectangle(2, 3);

        System.out.println(circle.getPerimeter());
        System.out.println(square.getPerimeter());
        System.out.println(rectangle.getPerimeter());

        // using lists
        System.out.println("------ Using lists ------ ");
        List<GeometricShape> shapes = List.of(circle, square, rectangle);

        for (GeometricShape shape: shapes) {
            System.out.println(shape.getPerimeter());
        }
    }
}
