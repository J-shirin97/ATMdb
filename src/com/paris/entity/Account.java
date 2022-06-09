package com.paris.entity;

public class Account {
    private int id;
    private String accountnumber;
    private String password;
    private Double balance;

    public int getId() {
        return id;
    }

    public Account setId(int id) {
        this.id = id;
        return this;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public Account setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public Double getBalance() {
        return balance;
    }

    public Account setBalance(Double balance) {
        this.balance = balance;
        return this;
    }
}

