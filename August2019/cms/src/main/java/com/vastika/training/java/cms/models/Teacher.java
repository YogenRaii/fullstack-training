package com.vastika.training.java.cms.models;

/**
 * Teacher model
 */
public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String subject;

    public Teacher(int id, String firstName, String lastName, String subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }
}
