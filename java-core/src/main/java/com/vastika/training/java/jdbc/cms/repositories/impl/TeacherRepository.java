package com.vastika.training.java.jdbc.cms.repositories.impl;

import com.vastika.training.java.jdbc.cms.util.DbConnector;
import com.vastika.training.java.jdbc.cms.models.Teacher;
import com.vastika.training.java.jdbc.cms.repositories.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements CrudRepository<Teacher> {

    @Override
    public List<Teacher> findAll() {
        Connection connection = DbConnector.getConnection();

        List<Teacher> teacherList = new ArrayList<>();
        String sql = "SELECT * FROM teacher";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String subject = resultSet.getString("subject");
                Teacher tea = new Teacher(id, firstName, lastName, subject);
                teacherList.add(tea);
            }
            return teacherList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher findById(int id) {
        Connection connection = DbConnector.getConnection();

        String sql = "SELECT * FROM teacher WHERE id = " + id;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                int teacherId = resultset.getInt("id");
                String firstName = resultset.getString("firstName");
                String lastName = resultset.getString("lastName");
                String subject = resultset.getString("subject");
                Teacher teacher = new Teacher(teacherId, firstName, lastName, subject);
                return teacher;
            }

        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public boolean update(Teacher teacher) {
        Connection connection = DbConnector.getConnection();

        String sql = "UPDATE teacher SET firstName = '" + teacher.getFirstName() +
                "', lastName = '" + teacher.getLastName() + "', subject = '" + teacher.getSubject() + "' WHERE id = " +
                teacher.getId();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection = DbConnector.getConnection();

        String sql = "DELETE FROM teacher WHERE id = " + id;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int resultSet = preparedStatement.executeUpdate();
            return resultSet > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
