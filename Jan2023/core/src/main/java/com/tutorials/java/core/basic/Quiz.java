package com.tutorials.java.core.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        List<Question> questions = getQuestions();

        for (Question question: questions) {
            print(question);
        }

    }

    private static List<Question> getQuestions() {
        Question question1 = new Question("What is capital city of Nepal",
                new String[]{"KTM", "Pokhara", "Ilam", "Chitwan"},
                "KTM");
        Question question2 = new Question("What is capital city of Nepal",
                new String[]{"KTM", "Pokhara", "Ilam", "Chitwan"},
                "KTM");
        Question question3 = new Question("What is capital city of Nepal",
                new String[]{"KTM", "Pokhara", "Ilam", "Chitwan"},
                "KTM");

        return List.of(question1, question2, question3);
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
    }
}
