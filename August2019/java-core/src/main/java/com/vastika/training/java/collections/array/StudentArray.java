package com.vastika.training.java.collections.array;

import com.vastika.training.java.collections.Student;

/**
 * syntax: class[] refName = new class[SIZE]; // declaration
 *
 * or
 *
 * class[] refName = new class[] {}; // declaration + initialization
 */
public class StudentArray {
    public static void main(String[] args) {
        Student dheeaj = new Student(1, "dheeraj", "cheetri", 4.0);
        Student saurav = new Student(2, "saurav", "cheetri", 4.0);
        Student rosan = new Student(3, "rosan", "cheetri", 4.0);
        Student[] students = new Student[] {dheeaj, saurav, rosan};

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];

            System.out.println(student);
/*
            System.out.println("id: " + student.getId());
            System.out.println("Firsname: " + student.getFirstName());
            System.out.println("lastname: " + student.getLastName());
            System.out.println("gpa: " + student.getGpa());*/
        }
    }
}
