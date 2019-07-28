package com.vastika.training.capstone.suchanaapi.controllers;

import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.models.Author;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import com.vastika.training.capstone.suchanaapi.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/authors")
    public ResponseEntity<List<Author>> findAll() {
        return new ResponseEntity<>(this.authorService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable("id") int id) {
        log.info("updateAuthor() -> {}", id);
        author.setId(id);
        return new ResponseEntity<>(this.authorService.update(author), HttpStatus.OK);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        log.info("createAuthor() -> {}", author);
        author.setDateCreated(LocalDateTime.now());

        return new ResponseEntity<>(this.authorService.createAuthor(author), HttpStatus.CREATED);
    }

    // /api/v1/users/{id}/accounts
    @PostMapping("/authors/{id}/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article,
                                                 @PathVariable("id") int authorId) {
        log.info("createArticle() -> authorId: {}", authorId);
        article.setPublishDate(LocalDateTime.now());

        Author author = this.authorService.findById(authorId);

        article.setAuthor(author);
        Article saved = this.articleService.save(article);

        log.info("Article saved -> id: {}", saved.getId());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/authors/{id}/articles")
    public ResponseEntity<List<Article>> getArticlesByAuthor(@PathVariable("id") int authorId) {
        return new ResponseEntity<>(this.articleService.findByAuthorId(authorId),
                HttpStatus.OK);
    }
}
