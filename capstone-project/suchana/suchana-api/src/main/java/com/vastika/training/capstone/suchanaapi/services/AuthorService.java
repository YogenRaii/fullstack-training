package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(int id);
    Author update(Author author);
    Author createAuthor(Author author);
}
