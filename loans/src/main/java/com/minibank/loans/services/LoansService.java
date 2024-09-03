package com.minibank.loans.services;

import com.minibank.loans.model.dtos.LoanRequestDTO;


public interface LoansService {
    void applyForLoan(LoanRequestDTO loanRequestDTO);
}
