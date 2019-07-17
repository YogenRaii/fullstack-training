package com.vastika.training.java.exceptions;

public class TryCatchFinally {
    public static void main(String[] args) {
        TryCatchFinally obj = new TryCatchFinally();
        int result = obj.divison(12, 10);
        System.out.println(result);

        result = obj.divison(12, 0);
        System.out.println(result);
    }

    public int divison(int dividend, int divisor) {
        try {
            int result = dividend / divisor;
            return result;
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        } finally {
            System.out.println("Done divison!");
        }
        return 0;
    }
}
