package com.paris.controller;

import com.paris.entity.Account;
import com.paris.model.AccountDB;


public class AccountController {

    public void save(String accountnumber , String password , Double balance) {
        try {
            Account account = null;
            if (accountnumber.length() != 0) {
                account = new Account().setAccountnumber(accountnumber).setPassword(password).setBalance(balance);
            }
            AccountDB accountDB = new AccountDB();
            accountDB.insert(account);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

