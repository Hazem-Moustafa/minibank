package com.minibank.loans.services.impl;

import com.minibank.loans.model.dtos.LoanRequestDTO;
import com.minibank.loans.services.LoansService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PersonalLoansService implements LoansService {
    @Override
    public void applyForLoan(LoanRequestDTO loanRequestDTO) {

    }
}
