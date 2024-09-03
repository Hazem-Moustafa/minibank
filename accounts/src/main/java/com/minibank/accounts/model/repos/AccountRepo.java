package com.minibank.accounts.model.repos;

import com.minibank.accounts.model.entities.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    @Transactional
    @Modifying
    boolean deleteByAccountNumber(String accountNumber);
}
