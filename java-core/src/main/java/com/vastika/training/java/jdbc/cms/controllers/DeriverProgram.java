package com.vastika.training.java.jdbc.cms.controllers;

import com.vastika.training.java.jdbc.cms.services.BaseService;
import com.vastika.training.java.jdbc.cms.services.impl.StudentService;
import com.vastika.training.java.jdbc.cms.services.impl.TeacherService;

import java.util.Scanner;


/**
 * final, finally, finalize() and their use in cms
 *
 * finally block -> to close the resources like connection, file stream
 *
 * static
 *
 * service injection
 *
 * parameter in prepared statements
 *
 *
 *
 * OOP principles:
 * P2I
 * Abstractions
 * Polymorphism
 * Inheritance
 *
 */
public class DeriverProgram {
    public static void main(String[] args) {
        BaseService studentService = new StudentService();

        BaseService teacherService = new TeacherService();

        String input = "yes";
        while (!"no".equals(input)) {
            System.out.println("Select:");
            System.out.println("1. For Teacher");
            System.out.println("2. For Student");

            Scanner scanner = new Scanner(System.in);
            int mainMenuChoice = scanner.nextInt();

            if (mainMenuChoice == 1) {
                teacherService.displayMenu();
            } else if (mainMenuChoice == 2) {
                studentService.displayMenu();
            }

            System.out.println("---------------------------");

            System.out.println("Do you want to search again? (yes/no)");
            Scanner inputScanner = new Scanner(System.in);
            input = inputScanner.next();
        }
    }
}
