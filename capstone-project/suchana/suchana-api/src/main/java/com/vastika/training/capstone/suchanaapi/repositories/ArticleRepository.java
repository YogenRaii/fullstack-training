package com.vastika.training.capstone.suchanaapi.repositories;

import com.vastika.training.capstone.suchanaapi.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // Native SQL version
    //    @Query(value = "select * from article a where a.author_id=?1", nativeQuery = true)
    //    List<Article> findAllByAuthor(Integer authorId);

    // HQL version
    @Query("from Article a where a.author.id=?1")
    List<Article> findAllByAuthor(Integer authorId);
}
