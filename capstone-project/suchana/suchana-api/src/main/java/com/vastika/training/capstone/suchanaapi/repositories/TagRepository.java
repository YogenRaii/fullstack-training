package com.vastika.training.capstone.suchanaapi.repositories;

import com.vastika.training.capstone.suchanaapi.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
