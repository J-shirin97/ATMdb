package com.paris.entity;

public class Account {
    private Long id;
    private String accountnumber;
    private String password;
    private Double balance;
    private Person person;
    private AccountType accountType;

    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
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

    public Person getPerson() {
        return person;
    }

    public Account setPerson(Person person) {
        this.person = person;
        return this;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Account setAccountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }
}

