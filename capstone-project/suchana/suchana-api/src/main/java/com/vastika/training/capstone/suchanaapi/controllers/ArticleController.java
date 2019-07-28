package com.vastika.training.capstone.suchanaapi.controllers;

import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> findArticles(@RequestParam(value = "category", required = false) String category,
                                                      @RequestParam(value = "tag", required = false) String tag) {
        List<Article> articles;
        if (category != null) {
            articles = this.articleService.findByCategory(category);
        } else if (tag != null) {
            articles = this.articleService.findByTag(tag);
        } else {
            articles = this.articleService.findAll();
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
}
