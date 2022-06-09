package com.paris.model;

import com.paris.common.JdbcConnection;
import com.paris.entity.Account;
import com.paris.entity.Person;

import java.sql.*;

public class AccountDB {

        Connection connection;


        public AccountDB() {
            JdbcConnection jdbcConnection = new JdbcConnection();
            connection = jdbcConnection.connect();
        }


        public void insert(Account account) {
            long dbId = 0;
            String SQL = "INSERT INTO account(accountnumber , password , balance ) " + "VALUES(?,?,?)";
            try {
                PreparedStatement prepareStatement = connection.prepareStatement(SQL,
                        Statement.RETURN_GENERATED_KEYS);
                prepareStatement.setString(1, account.getAccountnumber());
                prepareStatement.setString(2, account.getPassword());
                prepareStatement.setDouble(3, account.getBalance());


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
    }


