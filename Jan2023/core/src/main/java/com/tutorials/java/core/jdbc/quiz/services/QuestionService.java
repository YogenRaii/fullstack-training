package com.tutorials.java.core.jdbc.quiz.services;

import com.tutorials.java.core.jdbc.quiz.models.Question;
import com.tutorials.java.core.jdbc.quiz.repositories.QuestionRepository;

import java.util.List;

public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
