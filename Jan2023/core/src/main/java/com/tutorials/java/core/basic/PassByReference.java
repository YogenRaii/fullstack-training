package com.tutorials.java.core.basic;

import java.util.Scanner;

public class PassByReference {
    public static void main(String[] args) {
        Question question1 = new Question("What is capital city of Nepal",
                new String[]{"KTM", "Pokhara", "Ilam", "Chitwan"},
                "KTM"); // creates object in heap memory
        print(question1);
        print(question1);
    }


    private static void print(Question question) {
        System.out.println(question.getContent());
        for (int i = 1; i <= question.getOptions().length; i++) {
            System.out.println(i + "." + question.getOptions()[i - 1]);
        }
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        if (question.getCorrectAnswer().equals(question.getOptions()[answer -1])) {
            System.out.println("Correct");
        } else {
            System.out.println("Wrong");
        }

        question.setCorrectAnswer("wrong");
    }
}
