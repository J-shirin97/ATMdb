package com.paris.entity;

import java.sql.Timestamp;

public class Withdraw {

    private Long id;
    private Double amount;
    private Timestamp date;
    private Account account;
    private TransactionStatus transactionStatus;
    private TransactionType transactionType;

    public Long getId() {
        return id;
    }

    public Withdraw setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Withdraw setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Timestamp getDate() {
        return date;
    }

    public Withdraw setDate(Timestamp date) {
        this.date = date;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Withdraw setAccount(Account account) {
        this.account = account;
        return this;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Withdraw setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Withdraw setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }
}
