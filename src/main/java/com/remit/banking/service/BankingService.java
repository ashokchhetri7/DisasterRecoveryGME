package com.remit.banking.service;

import com.remit.banking.dto.AccountBalance;
import org.springframework.stereotype.Service;

@Service
public class BankingService {
    public AccountBalance getAccountBalance(String accountNumber){
        AccountBalance balance = new AccountBalance();
        balance.setAccountNumber(accountNumber);
        balance.setBalance((54350000.00));
        return balance;
    }

}
