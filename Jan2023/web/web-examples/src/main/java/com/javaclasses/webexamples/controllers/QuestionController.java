package com.javaclasses.webexamples.controllers;

import com.javaclasses.webexamples.models.Question;
import com.javaclasses.webexamples.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionsRepository questionsRepository;

    //    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/questions")
    public List<Question> findAll() {
        return questionsRepository.findAll();
    }
}
