package com.vastika.training.java.jdbc.cms;

import java.util.List;

public class DeriverProgram {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        List<Student> students = repository.getAllStudents();

        System.out.println(students);
    }
}
