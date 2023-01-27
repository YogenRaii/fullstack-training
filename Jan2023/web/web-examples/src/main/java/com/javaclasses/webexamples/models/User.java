package com.javaclasses.webexamples.models;

public class User {
    private int id;
    private String email;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age >= 200) {
            throw new IllegalArgumentException("Age must be between 1 year to 200 years");
        }
        this.age = age;
    }
}
