package com.vastika.training.java.polymorphism.basics;

public class DriverClass {
    public static void main(String[] args) {
        /**
         * Runtime polymorphism -> the method to be called is determined at runtime
         */
        GeometricShape c1 = new Circle(10);

        double c1Perimeter = c1.getPerimeter();
        System.out.println(c1Perimeter);

        /**
         * instanceof keyword to check if object is of type class
         *
         * (object instanceof Class)
         */
        boolean c1Circle = c1 instanceof Circle;
        boolean c1Object = c1 instanceof Object;
        boolean c1Geometric = c1 instanceof GeometricShape;


        System.out.println(c1Circle);
        System.out.println(c1Object);
        System.out.println(c1Geometric);

        GeometricShape r1 = new Rectangle(10, 20);

        double r1Perimter = r1.getPerimeter();
        System.out.println(r1Perimter);

        boolean r1Rectangle = r1 instanceof Rectangle;

        System.out.println(r1Rectangle);


    }
}
