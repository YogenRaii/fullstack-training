package com.vastika.training.java.jdbc.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements CrudRepository<Student> {
    @Override
    public List<Student> findAll() {
        Connection connection = DbConnector.getConnection();

        List<Student> students = new ArrayList<>();

        try {
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
        Connection connection = DbConnector.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("select * from student where id = " + userId);

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
        Connection connection = DbConnector.getConnection();

        try {
            String sql = "update student set firstName='" + student.getFirstName()
                    + "', lastName='" + student.getLastName() + "', gpa=" + student.getGpa() + " where id=" + student.getId();

            PreparedStatement ps = connection.prepareStatement(sql);

            int rs = ps.executeUpdate();

            return rs > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(int studentId) {
        Connection connection = DbConnector.getConnection();

        try {
            String sql = "delete from student where id = " + studentId;

            PreparedStatement ps = connection.prepareStatement(sql);

            int rs = ps.executeUpdate();

            return rs > 0 ? true: false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
