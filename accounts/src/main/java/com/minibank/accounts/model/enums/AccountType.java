package com.minibank.accounts.model.enums;

public enum AccountType {
    SAVINGS("Savings Account"),
    CHECKING("Checking Account"),
    CREDIT("Credit Account");

    private final String displayName;

    AccountType(String displayName){
       this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}