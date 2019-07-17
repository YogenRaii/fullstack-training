package com.vastika.training.java.jdbc.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    /**
     * Util method to provider jdbc connection
     * @return
     */
    public static Connection getConnection() {

        // register driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establish a connection with db
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Db connection done!");
        }

        return null;
    }
}
