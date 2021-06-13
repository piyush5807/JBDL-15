package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            createTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void createTable() throws SQLException {

        // Java database connectivity
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl15", "root", "");

        Statement statement = connection.createStatement();

        statement.execute("create table test(id INT PRIMARY KEY, name VARCHAR(30), age INT)");
    }
}

