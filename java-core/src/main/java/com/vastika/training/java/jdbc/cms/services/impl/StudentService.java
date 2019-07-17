package com.vastika.training.java.jdbc.cms.services.impl;

import com.vastika.training.java.jdbc.cms.models.Student;
import com.vastika.training.java.jdbc.cms.repositories.impl.StudentRepository;
import com.vastika.training.java.jdbc.cms.services.BaseService;

import java.util.List;
import java.util.Scanner;

public class StudentService implements BaseService {

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select: ");
        System.out.println("1. To list all student");
        System.out.println("2. To print student details");
        System.out.println("3. To update student record");
        System.out.println("4. To delete student record");

        // add functionality to delete

        System.out.println("---------------------------");

        int choice = scanner.nextInt();

        StudentRepository repository = new StudentRepository();

        if (choice == 1) {
            List<Student> students = repository.findAll();

            System.out.println(students);
        } else if (choice == 2) {

            System.out.print("Enter student id: ");
            int studentId = scanner.nextInt();
            Student studentId2 = repository.findById(studentId);
            System.out.println(studentId2);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student id: ");
            int id = Integer.valueOf(sc.next());
            System.out.print("Enter student first name: ");
            String firstName = sc.next();
            System.out.print("Enter student last name: ");
            String lastName = sc.next();
            System.out.print("Enter student gpa: ");
            double gpa = Double.valueOf(sc.next());
            Student toUpdate = new Student(id, firstName, lastName, gpa);

            boolean updated = repository.update(toUpdate);

            if (updated) {
                System.out.println("Success!");
            } else {
                System.out.println("Failed!");
            }
        } else if (choice == 4) {

            System.out.print("Enter student id: ");
            int studentId = scanner.nextInt();
            boolean deleted = repository.deleteById(studentId);

            if (deleted) {
                System.out.println("Success");
            } else {
                System.out.println("Failed!");
            }
        }
    }
}
