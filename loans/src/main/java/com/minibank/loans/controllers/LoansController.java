package com.minibank.loans.controllers;

import com.minibank.loans.model.dtos.LoanDTO;
import com.minibank.loans.model.dtos.LoanRequestDTO;
import com.minibank.loans.services.LoanServiceFactory;
import com.minibank.loans.services.LoansService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loans")
@Tag(name = "Bank Management System : Loans APIs")
@RequiredArgsConstructor
public class LoansController {

    private final LoanServiceFactory loanServiceFactory;

    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@RequestBody @Valid LoanRequestDTO loanRequest) {
        LoansService loansService=loanServiceFactory.getLoanService(loanRequest.loanType());
        loansService.applyForLoan(loanRequest);
        return ResponseEntity.ok().build();
    }
}
