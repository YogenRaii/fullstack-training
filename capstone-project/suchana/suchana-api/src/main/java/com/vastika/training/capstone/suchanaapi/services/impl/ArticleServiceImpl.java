package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.models.Article;
import com.vastika.training.capstone.suchanaapi.repositories.ArticleRepository;
import com.vastika.training.capstone.suchanaapi.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        log.info("save()");
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    @Override
    public List<Article> findByAuthorId(Integer authorId) {
        return this.articleRepository.findAllByAuthor(authorId);
    }
}
