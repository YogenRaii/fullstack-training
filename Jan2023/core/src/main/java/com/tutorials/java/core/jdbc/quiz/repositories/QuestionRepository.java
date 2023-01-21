package com.tutorials.java.core.jdbc.quiz.repositories;

import com.tutorials.java.core.jdbc.quiz.models.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findAll();
    boolean insert(Question question);
}
