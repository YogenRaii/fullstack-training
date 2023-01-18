package com.tutorials.java.core.collections;

import com.tutorials.java.core.basic.Question;

public class Arrays {
    public static void main(String[] args) {
//        int[] evens = new int[4];
//        evens[0] = 2;
//        evens[1] = 4;
//        evens[2] = 6;
//        evens[3] = 6;

        int[] evens = new int[] {2, 4, 6, 6};

        for (int e: evens) {
            System.out.println(e);
        }

        Question[] questions = new Question[2];
        questions[0] = new Question("What is capital city of Nepal",
                new String[]{"KTM", "Pokhara", "Ilam", "Chitwan"},
                "KTM");
        questions[1] = new Question("What is capital city of Nepal",
                new String[]{"KTM", "Pokhara", "Ilam", "Chitwan"},
                "KTM");
    }
}
