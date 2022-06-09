package com.paris.model;

import com.paris.common.JdbcConnection;
import com.paris.entity.*;

import java.sql.*;

public class WithdrawDB {
    Connection connection;

    public WithdrawDB() {
        JdbcConnection jdbcConnection = new JdbcConnection();
        connection = jdbcConnection.connect();

    }

    public void insert(Withdraw withdraw) {
        long dbId = 0;
        Account account = new Account();
        TransactionType transactionType = new TransactionType();
        TransactionStatus transactionStatus = new TransactionStatus();

        String SQL = "INSERT INTO TRANSACTION(amount , createddate , accountid , transactionstatusid , transactiontypeid) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, withdraw.getAmount());
            preparedStatement.setTimestamp(2, withdraw.getDate());
            preparedStatement.setDouble(3, withdraw.getId());
            preparedStatement.setDouble(4, transactionStatus.getId());
            preparedStatement.setDouble(5, transactionType.getId());


            int affectedRows = preparedStatement.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
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

