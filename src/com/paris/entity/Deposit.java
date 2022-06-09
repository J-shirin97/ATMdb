package com.paris.entity;

import java.sql.Timestamp;

public class Deposit {


    private Long id;
    private Double amount;
    private Timestamp date;
    private Account account;
    private TransactionStatus transactionStatus;
    private TransactionType transactionType;

    public Long getId() {
        return id;
    }

    public Deposit setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Deposit setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Timestamp getDate() {
        return date;
    }

    public Deposit setDate(Timestamp date) {
        this.date = date;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Deposit setAccount(Account account) {
        this.account = account;
        return this;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Deposit setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Deposit setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }
}
