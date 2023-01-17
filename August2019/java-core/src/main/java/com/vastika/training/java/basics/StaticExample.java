package com.vastika.training.java.basics;

/**
 * static is for class, not for instance/object
 */
public class StaticExample {
    private static int count = 0;

    public StaticExample() {
        count++;
    }

    public static void print(String name) {
        System.out.println("Hello, " + name);
    }

    public int getCount() {
        return count;
    }

    /**
     * public -> so that jvm can call main method
     * static -> so that jvm can call without creating instance of the class
     * void -> jvm doesn't expect any value to be returned
     *
     * @param args
     */
    public static void main(String[] args) {
        StaticExample.print("Dheeraj");

        StaticExample e1 = new StaticExample();
        System.out.println(e1.getCount());

        StaticExample e2 = new StaticExample();
        System.out.println(e1.getCount());
        System.out.println(e2.getCount());
    }
}
