package com.tutorials.java.core.jdbc.quiz.controllers;

import com.tutorials.java.core.jdbc.quiz.models.Question;
import com.tutorials.java.core.jdbc.quiz.repositories.impl.QuestionRepositoryImpl;
import com.tutorials.java.core.jdbc.quiz.services.QuestionService;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
//        Question question1 = new Question("What is alphabet?", "a", "cd", "A", "B", "A");
        System.out.println("Select user:");
        System.out.println("1. Player");
        System.out.println("2. Admin");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input == 1) {
            QuestionService questionService = new QuestionService(new QuestionRepositoryImpl());
            List<Question> questions = questionService.findAll();
            System.out.println("Total questions: " + questions.size());

            for (int i = 0; i < questions.size(); i++) {
                System.out.println((i + 1) + "/" + questions.size());
                print(questions.get(i));
            }
        } else {
            // do admin function
        }

    }


    private static void print(Question question) {
        System.out.println(question.getContent());
        String[] options = new String[]{question.getOption1(),
                question.getOption2(),
                question.getOption3(),
                question.getOption4()};
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + "." + options[i - 1]);
        }
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        if (question.getCorrectAnswer().equals(options[answer - 1])) {
            System.out.println("Correct");
        } else {
            System.out.println("Wrong");
        }
    }
}
