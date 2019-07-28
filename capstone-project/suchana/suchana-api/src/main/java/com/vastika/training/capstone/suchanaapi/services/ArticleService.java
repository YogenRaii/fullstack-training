package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.Article;

import java.util.List;

public interface ArticleService {
    Article save(Article article);
    List<Article> findAll();

    List<Article> findByAuthorId(Integer authorId);
}
