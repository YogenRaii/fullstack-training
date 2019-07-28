package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category update(Category category);
    void deleteById(int id);
    Category createCategory(Category category);
}
