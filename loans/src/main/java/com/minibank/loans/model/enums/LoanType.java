package com.minibank.loans.model.enums;

public enum LoanType {
    PERSONAL("Personal Loan"),
    MORTGAGE("Mortgage Loan");

    private final String loanName;

    LoanType(String loanName){
        this.loanName = loanName;
    }

    @Override
    public String toString() {
        return loanName;
    }
}
