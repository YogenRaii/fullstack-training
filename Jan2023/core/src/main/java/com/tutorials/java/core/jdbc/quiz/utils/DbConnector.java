package com.tutorials.java.core.jdbc.quiz.utils;

import com.tutorials.java.core.jdbc.quiz.exceptions.QuizRuntimeException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnector {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
        } catch (SQLException th) {
            throw new QuizRuntimeException(th.getMessage());
        }
    }
}
