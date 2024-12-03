package com.remit.banking.service;

import com.remit.banking.dto.AccountBalance;
import org.springframework.stereotype.Service;

@Service
public class BankingService {
    public AccountBalance getAccountBalance(String accountNumber) {
        // In a real-world scenario, this would fetch from a database
        AccountBalance balance = new AccountBalance();
        balance.setAccountNumber(accountNumber);
        balance.setBalance(50000.00);
        return balance;
    }
}