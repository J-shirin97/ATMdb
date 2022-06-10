package com.paris.action;

import com.paris.entity.TransactionType;
import com.paris.entity.Withdraw;

public class WithdrawAction {
    public void insert(Withdraw withdraw){
        TransactionType type = new TransactionType();
        withdraw.setTransactionType(type.setValue(2));
    }
}
