package com.vastika.training.java.jdbc.basics;

import java.sql.*;

public class DriverClass {
    public static void main(String[] args) {
        try {
            // register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establish a connection with db
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            // prepare statement with SQL using connection
            PreparedStatement statement = connection.prepareStatement("select * from student");

            // execute statement created
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double gpa = rs.getDouble("gpa");

                System.out.println(id +" , " + firstName + ", " + lastName +", " + gpa);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
