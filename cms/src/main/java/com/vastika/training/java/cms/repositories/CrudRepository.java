package com.vastika.training.java.cms.repositories;

import java.util.List;

/**
 * P2I -> Program to interface
 * @param <T>
 */
public interface CrudRepository<T> {
    List<T> findAll();
    T findById(int id);
    boolean update(T t);
    boolean deleteById(int id);
    void insert(T t);
}
