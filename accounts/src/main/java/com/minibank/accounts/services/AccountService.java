package com.minibank.accounts.services;

import com.minibank.accounts.model.dtos.AccountDTO;
import com.minibank.accounts.model.dtos.CreateAccountDTO;

public interface AccountService {

    AccountDTO createAccount(CreateAccountDTO account);
    AccountDTO getAccount(String accountNumber);
    boolean deleteAccount(String accountNumber);
}
