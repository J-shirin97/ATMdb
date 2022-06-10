package com.paris.model;

import com.paris.common.JdbcConnection;
import com.paris.entity.Account;
import com.paris.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDB {
    Connection connection;


    public PersonDB() {
        JdbcConnection jdbcConnection = new JdbcConnection();
        connection = jdbcConnection.connect();
    }


    public void insert(Person person) {
        long dbId = 0;
        String sql = "INSERT INTO person(firstName,lastName,nationalCode,age) VALUES(?,?,?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, person.getFirstName());
            prepareStatement.setString(2, person.getLastName());
            prepareStatement.setString(3, person.getNationalCode());
            prepareStatement.setInt(4, person.getAge());

            int affectedRows = prepareStatement.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                ResultSet rs = prepareStatement.getGeneratedKeys();
                if (rs.next()) {
                    dbId = rs.getLong("id");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Person person) {
        String sql = "update person set firstName = ? , lastName = ? , nationalCode = ? , age = ? where id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getNationalCode());
            preparedStatement.setInt(4, person.getAge());
            preparedStatement.setLong(5, person.getId());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<Person> selectAll() {
        List<Person> personList = new ArrayList<>();
        String sql = "select * from person";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person()
                        .setId(resultSet.getLong("id"))
                        .setFirstName(resultSet.getString("firstName"))
                        .setLastName(resultSet.getString("lastName"))
                        .setNationalCode(resultSet.getString("nationalCode"))
                        .setAge(resultSet.getInt("age"));
                personList.add(person);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return personList;
    }

    public void delete(Long id) {
        String sql = "delete from person where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}








