package com.paris.model;

import com.paris.common.JdbcConnection;
import com.paris.entity.*;

import java.sql.*;

public class DepositDB {
    Connection connection;

    public DepositDB() {
        JdbcConnection jdbcConnection = new JdbcConnection();
        connection = jdbcConnection.connect();

    }

    public void insert(Deposit deposit) {
        long dbId = 0;
        Account account = new Account();
        TransactionType transactionType = new TransactionType();
        TransactionStatus transactionStatus = new TransactionStatus();

        String SQL = "INSERT INTO TRANSACTION(amount , createddate , accountid , transactionstatusid , transactiontypeid) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, deposit.getAmount());
            preparedStatement.setTimestamp(2, deposit.getDate());
            preparedStatement.setDouble(3, deposit.getId());
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



