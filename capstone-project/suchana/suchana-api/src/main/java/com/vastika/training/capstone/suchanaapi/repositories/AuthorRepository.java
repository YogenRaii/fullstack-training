package com.vastika.training.capstone.suchanaapi.repositories;

import com.vastika.training.capstone.suchanaapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
