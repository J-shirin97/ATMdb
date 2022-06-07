package com.paris.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public Connection connect(){
        String url = "jdbc:postgresql://localhost:5432/paris_db";
        String user = "postgres";
        String password = "12345";
        try {
            Connection   conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
