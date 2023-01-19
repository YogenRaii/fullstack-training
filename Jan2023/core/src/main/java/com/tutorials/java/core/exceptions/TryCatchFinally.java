package com.tutorials.java.core.exceptions;

public class TryCatchFinally extends Object {
    public static void main(String[] args) {
        try {
            double result = 5 / 1;
        } catch (Exception ex) {
            // handle
            System.out.println("inside catch block");
            System.out.println(ex);
        } finally {
            // gets executed regardless of exceptions
            System.out.println("inside finally block");
        }
    }
}
