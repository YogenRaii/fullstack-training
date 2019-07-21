package com.vastika.training.java.cms.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Teacher model
 */
@Entity
public class Teacher {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String subject;

    public Teacher() {
    }

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
