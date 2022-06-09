package com.paris.model;

import com.paris.common.JdbcConnection;
import com.paris.entity.Account;
import com.paris.entity.AccountType;
import com.paris.entity.Person;

import java.sql.*;

public class AccountDB {

    Connection connection;


    public AccountDB() {
        JdbcConnection jdbcConnection = new JdbcConnection();
        connection = jdbcConnection.connect();


    }


    public void insert(Account account) {
        Person person = new Person();
        AccountType accountType = new AccountType();
        long dbId = 0;
        String SQL = "INSERT INTO account(accountnumber , password , balance , person , accountType ) " + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, account.getAccountnumber());
            prepareStatement.setString(2, account.getPassword());
            prepareStatement.setDouble(3, account.getBalance());
            prepareStatement.setDouble(4, person.getId());
            prepareStatement.setDouble(5, accountType.getId());


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
    }

    public Account findOne(String accountNumber) {
        Account account = new Account();
        String SQL = "select * from account where accountNumber = " + accountNumber;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account.setAccountnumber(accountNumber);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }


}


