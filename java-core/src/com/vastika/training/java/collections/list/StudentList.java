package com.vastika.training.java.collections.list;

import com.vastika.training.java.collections.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        Student dheeaj = new Student(1, "dheeraj", "cheetri", 4.0);
        Student saurav = new Student(2, "saurav", "cheetri", 4.0);
        Student rosan = new Student(3, "rosan", "cheetri", 4.0);

        // list of students
        List<Student> list = new ArrayList<>();
        list.add(dheeaj);
        list.add(saurav);
        list.add(rosan);

        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student);
        }

        List<Integer> integers = new ArrayList<>();
        for (int n = 1; n <= 10; n++) {
            integers.add(n);
        }

        integers.add(2);
        integers.add(10);
        integers.add(2);

        System.out.println(integers);

        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) % 2 == 0) {
                System.out.println(integers.get(i));
            }
        }

        /**
         * for(type localVar: coll) {
         *  //
         * }
         */
        for (int n: integers) {
            if (n % 2 == 0) {
                System.out.println(n);
            }

        }
    }
}
