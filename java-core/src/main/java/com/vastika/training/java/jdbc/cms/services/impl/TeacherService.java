package com.vastika.training.java.jdbc.cms.services.impl;

import com.vastika.training.java.jdbc.cms.models.Teacher;
import com.vastika.training.java.jdbc.cms.repositories.CrudRepository;
import com.vastika.training.java.jdbc.cms.repositories.impl.TeacherRepository;
import com.vastika.training.java.jdbc.cms.services.BaseService;

import java.util.List;
import java.util.Scanner;

public class TeacherService implements BaseService {

    private CrudRepository<Teacher> repository;

    public TeacherService() {
        this.repository = new TeacherRepository();
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select: ");
        System.out.println("1. To list all teacher");
        System.out.println("2. To print teacher details");
        System.out.println("3. To update teacher record");
        System.out.println("4. To delete teacher record");

        // add functionality to delete

        System.out.println("---------------------------");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                List<Teacher> teachers = repository.findAll();
                System.out.println(teachers);
                break;
            case 2:
                printInfo();
                break;
            case 3:
                updateInfo();
                break;
            case 4:
                deleteRecord();
                break;
            default:
                System.out.println("Invalid input!");

        }
    }

    public void deleteRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student id: ");
        int teacherId = scanner.nextInt();
        boolean deleted = repository.deleteById(teacherId);

        if (deleted) {
            System.out.println("Success");
        } else {
            System.out.println("Failed!");
        }
    }

    public void updateInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter teacher id: ");
        int id = Integer.valueOf(sc.next());
        System.out.print("Enter teacher first name: ");
        String firstName = sc.next();
        System.out.print("Enter teacher last name: ");
        String lastName = sc.next();
        System.out.print("Enter teacher subject: ");
        String subject = sc.next();
        Teacher toUpdate = new Teacher(id, firstName, lastName, subject);

        boolean updated = repository.update(toUpdate);

        if (updated) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }
    }

    public void printInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter teacher id: ");
        int teacherId = scanner.nextInt();
        Teacher teacher = repository.findById(teacherId);
        System.out.println(teacher);
    }
}
