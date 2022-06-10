package com.paris.controller;

import com.paris.entity.Account;
import com.paris.model.AccountDB;


public class AccountController {

    public void save(String accountNumber , String password , Double balance , Double personId, Double accountTypeId) {
        try {
            Account account = null;
            if (accountNumber.length() != 0) {
                account = new Account().setAccountNumber(accountNumber).setPassword(password).setBalance(balance);
            }
            AccountDB accountDB = new AccountDB();
            accountDB.insert(account);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void login(String accountNumber , String password){
        try{
            AccountDB accountDB = new AccountDB();
            Account account = accountDB.findOne(accountNumber);
            if (accountNumber.equals(account)){
                System.out.println("Success");
            }else {
                System.out.println("failed");
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}

