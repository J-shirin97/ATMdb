package com.paris.model;

import com.paris.common.JdbcConnection;
import com.paris.entity.Account;
import com.paris.entity.Transaction;
import com.paris.entity.TransactionStatus;
import com.paris.entity.TransactionType;

import java.sql.*;

public class TransactionDB {
    Connection connection;

    public TransactionDB() {
        JdbcConnection jdbcConnection = new JdbcConnection();
        connection = jdbcConnection.connect();

    }

    public void insert(Transaction transaction) {
        long dbId = 0;
        Account account = new Account();
        TransactionType transactionType = new TransactionType();
        TransactionStatus transactionStatus = new TransactionStatus();

        String SQL = "INSERT INTO TRANSACTION(amount , createddate , accountid , transactionstatusid , transactiontypeid) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, transaction.getAmount());
            preparedStatement.setTimestamp(2, transaction.getDate());
            preparedStatement.setDouble(3, transaction.getId());
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
