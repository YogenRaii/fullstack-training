package com.javaclasses.webexamples.repositories;

import com.javaclasses.webexamples.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Question, Integer> {
}
