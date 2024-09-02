package com.minibank.accounts.model.listeners;

import com.minibank.accounts.model.entities.Account;
import jakarta.persistence.PrePersist;

import java.util.UUID;

public class AccountListener {

    private static final ThreadLocal<Long> currentTimeMillisThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<UUID> uuidThreadLocal = new ThreadLocal<>();

    @PrePersist
    public void generateAccountNumberAndUuid(Account account) {
        if (account.getAccountNumber() == null) {
            account.setAccountNumber(generateUniqueAccountNumber());
        }
        if (account.getAccountUuid() == null){
            account.setAccountUuid(generateUniqueAccountUuid());
        }
    }

    private String generateUniqueAccountNumber() {
        Long currentTimeMillis = System.currentTimeMillis();
        currentTimeMillisThreadLocal.set(currentTimeMillis);
        return "ACC-" + currentTimeMillisThreadLocal.get();
    }

    private UUID generateUniqueAccountUuid(){
        UUID uuid = UUID.randomUUID();
        uuidThreadLocal.set(uuid);
        return uuidThreadLocal.get();
    }
}