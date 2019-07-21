package com.vastika.training.java.cms.repositories.impl;


import com.vastika.training.java.cms.models.Student;
import com.vastika.training.java.cms.repositories.CrudRepository;
import com.vastika.training.java.cms.util.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements CrudRepository<Student> {
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DbConnector.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("select * from student");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double gpa = rs.getDouble("gpa");

                Student student = new Student(id, firstName, lastName, gpa);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student findById(int userId) {

        try(Connection connection = DbConnector.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("select * from student where id=?");
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double gpa = rs.getDouble("gpa");

                return new Student(id, firstName, lastName, gpa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Student student) {

        try(Connection connection = DbConnector.getConnection()) {
            String sql = "update student set firstName=?, lastName=?, gpa=? where id=?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setDouble(3, student.getGpa());
            ps.setInt(4, student.getId());

            int rs = ps.executeUpdate();

            return rs > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int studentId) {
        try ( Connection connection = DbConnector.getConnection()) {
            String sql = "delete from student where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);

            int rs = ps.executeUpdate();

            return rs > 0 ? true: false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void insert(Student student) {
        try (Connection connection = DbConnector.getConnection()){
            String sql = "INSERT INTO STUDENT (id, firstName, lastName, gpa) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setDouble(4, student.getGpa());
            preparedStatement.execute();
            System.out.println("Data inserted into Students.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
