package com.vastika.training.java.jdbc.cms.repositories;

import java.util.List;

/**
 * P2I -> Program to interface
 * @param <S>
 */
public interface CrudRepository<S> {
    List<S> findAll();
    S findById(int id);
    boolean update(S t);
    boolean deleteById(int id);
}
