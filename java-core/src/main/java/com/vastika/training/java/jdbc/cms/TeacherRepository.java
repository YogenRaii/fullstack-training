package com.vastika.training.java.jdbc.cms;

import java.util.List;

public class TeacherRepository implements CrudRepository<Teacher> {

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher findById(int id) {
        return null;
    }

    @Override
    public boolean update(Teacher teacher) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
