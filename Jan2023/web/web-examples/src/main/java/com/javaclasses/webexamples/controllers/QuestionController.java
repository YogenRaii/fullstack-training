package com.javaclasses.webexamples.controllers;

import com.javaclasses.webexamples.models.Question;
import com.javaclasses.webexamples.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * GET /api/v1/questions/{id} > 200 Success 404 Not Found
 * POST - Creates /api/v1/questions > 201 Created 400 Data Error 409 - Conflicts
 * PUT - Complete entity /api/v1/questions/{id} > 200 Success, 404 - Not Found
 * PATCH - Partial update /api/v1/questions/{id}
 * DELETE /api/v1/questions/{id}
 */
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionsRepository questionsRepository;

    @GetMapping
    public List<Question> findAll() {
        return questionsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable Integer id) {
        return questionsRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity
                                .notFound()
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question created = questionsRepository.save(question);
        return ResponseEntity
                .created(
                        URI.create("/api/v1/questions/" + created.getId())
                )
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question question) {
        Question updated = questionsRepository.save(question);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable int id) {
        questionsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
