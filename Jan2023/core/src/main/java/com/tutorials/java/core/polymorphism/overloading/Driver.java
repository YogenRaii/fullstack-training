package com.tutorials.java.core.polymorphism.overloading;

public class Driver {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print("hello");
        printer.print("hello", 5);
        printer.print("hello", 5, false);
    }
}
