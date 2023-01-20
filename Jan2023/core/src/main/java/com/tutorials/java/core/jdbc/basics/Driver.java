package com.tutorials.java.core.jdbc.basics;

import java.sql.*;

public class Driver {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // students
        // create table students (id serial primary key not null, first_name varchar(60),
        // last_name varchar(60), batch varchar(10));

        // select * from students

        // insert into students values(1, 'yogen', 'rai', '2023Fall');

        // try with resource
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres")) {
            executeSelectQuery(connection);

            executeInsertQuery(connection);

            System.out.println("After insertion...");

            executeSelectQuery(connection);
        }

    }

    private static void executeInsertQuery(Connection connection) throws SQLException {
        PreparedStatement insertStatement = connection.prepareStatement("insert into students(first_name, last_name, batch) values('yogesh', 'rai', '2024Fall')");
        if (insertStatement.execute()) {
            System.out.println("insertion successful..");
        } else {
            System.out.println("error while inserting data...");
        }
    }

    private static void executeSelectQuery(Connection connection) throws SQLException {
        PreparedStatement selectStatement = connection.prepareStatement("select * from students");

        ResultSet rs = selectStatement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String batch = rs.getString("batch");
            System.out.printf("Student: %d %s %s %s\n", id, firstName, lastName, batch);
        }
    }
}
