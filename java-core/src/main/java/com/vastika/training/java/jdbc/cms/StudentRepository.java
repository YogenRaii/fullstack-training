package com.vastika.training.java.jdbc.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> getAllStudents() {
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
}
