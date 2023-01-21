package com.tutorials.java.core.jdbc.quiz.repositories.impl;

import com.tutorials.java.core.jdbc.quiz.models.Question;
import com.tutorials.java.core.jdbc.quiz.repositories.QuestionRepository;
import com.tutorials.java.core.jdbc.quiz.utils.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = DbConnector.getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement("select * from questions");

            ResultSet rs = selectStatement.executeQuery();

            while (rs.next()) {
                String content = rs.getString("content");
                String option1 = rs.getString("option1");
                String option2 = rs.getString("option2");
                String option3 = rs.getString("option3");
                String option4 = rs.getString("option4");
                String correctAnswer = rs.getString("correctAnswer");
                Question question = new Question(content, option1, option2, option3, option4, correctAnswer);
                questions.add(question);
            }
        } catch (SQLException th) {
            th.printStackTrace();
        }
        return questions;
    }

    @Override
    public boolean insert(Question question) {
        return false;
    }
}
