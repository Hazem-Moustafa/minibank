package com.minibank.loans.services;

import com.minibank.loans.services.impl.MortgageLoansService;
import com.minibank.loans.services.impl.PersonalLoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanServiceFactory {

    private final PersonalLoansService personalLoansService;
    private final MortgageLoansService mortgageLoansService;

    public LoansService getLoanService(String loanType) {
        switch (loanType.toLowerCase()) {
            case "personal":
                return personalLoansService;
            case "mortgage":
                return mortgageLoansService;
            default:
                throw new IllegalArgumentException("Unknown loan type: " + loanType);
        }
    }
}
