package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double amount;
    
    public CustomerAccount(Double amount) {
        this.amount = amount;
    }

    public void add(Double addedAmount) {
        this.amount += addedAmount;
    }

    public Double getBalance() {
        return this.amount;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
    	Double result=0.0;
    	result = this.amount - withdrawnAmount;
        if (rule.withdrawPermitted(result)) {
            return result;
        } else {
            throw new IllegalBalanceException(result);
        }
    }

}
