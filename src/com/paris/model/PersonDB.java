package com.paris.model;

import com.paris.common.JdbcConnection;
import com.paris.entity.Person;

import java.sql.*;

public class PersonDB {
    Connection connection;


    public PersonDB() {
        JdbcConnection jdbcConnection = new JdbcConnection();
        connection = jdbcConnection.connect();
    }


    public long insert(Person person) {
        long dbId = 0;
        String SQL = "INSERT INTO person(firstName,lastName,nationalCode,age) " + "VALUES(?,?,?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, person.getFirstName());
            prepareStatement.setString(2, person.getLastName());
            prepareStatement.setString(3, person.getNationalCode());
            prepareStatement.setInt(4, person.getAge());

            int affectedRows = prepareStatement.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = prepareStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        dbId = rs.getLong("id");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dbId;
    }
}
