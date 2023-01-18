package com.tutorials.java.core.basic;

public class Question {
    private String content;
    private String[] options;
    private String correctAnswer;

    public Question(String content, String[] options, String correctAnswer) {
        this.content = content;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getContent() {
        return content;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String newCorrectAnswer) {
        this.correctAnswer = newCorrectAnswer;
    }
}

