package com.vastika.training.java.polymorphism.overloading;

public class DriverClass {
    public static void main(String[] args) {
        Printer printer = new Printer();

        printer.print("yogen");
        printer.print("yogen", 20);
        printer.print("yogen", "Plano, TX");
        printer.print("yogen", "Plano, TX", "Tula");
    }
}
