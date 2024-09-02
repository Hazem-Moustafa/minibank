package com.minibank.accounts.services.impl;

import com.minibank.accounts.exceptions.ResourceNotFound;
import com.minibank.accounts.model.dtos.AccountDTO;
import com.minibank.accounts.model.dtos.CreateAccountDTO;
import com.minibank.accounts.model.entities.Account;
import com.minibank.accounts.model.mappers.AccountMapper;
import com.minibank.accounts.model.repos.AccountRepo;
import com.minibank.accounts.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepo accountRepo;

    /**
     * Creates a new account based on the provided account details.
     *
     * @param account the account details used to create the account
     * @return the created account as an AccountDTO object
     */
    @Override
    public AccountDTO createAccount(CreateAccountDTO account) {

        Account newAccount = accountMapper.convertToEntity(account);
        newAccount = accountRepo.save(newAccount);

        return accountMapper.convertToDto(newAccount, AccountDTO.class);
    }

    /**
     * @param accountNumber
     * @return
     */
    @Override
    public AccountDTO getAccount(String accountNumber) {
        Account account = accountRepo.findAccountByAccountNumber(accountNumber).orElseThrow(ResourceNotFound::new);
        return accountMapper.convertToDto(account, AccountDTO.class);
    }

    /**
     * Deletes an account with the given account number from the repository.
     *
     * @param accountNumber the account number of the account to be deleted
     * @return true if the account is successfully deleted, false otherwise
     * @throws ResourceNotFound if the account with the given account number is not found
     */
    @Override
    public boolean deleteAccount(String accountNumber) {
        boolean isDeleted = false;
        Account account=accountRepo.findAccountByAccountNumber(accountNumber).orElseThrow(ResourceNotFound::new);
        isDeleted = accountRepo.deleteByAccountNumber(account.getAccountNumber());
        return isDeleted;
    }
}
