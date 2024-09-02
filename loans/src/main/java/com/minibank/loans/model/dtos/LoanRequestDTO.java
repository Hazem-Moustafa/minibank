package com.minibank.loans.model.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

import static com.minibank.loans.infrastructure.utils.Constants.LOAN_TYPE_NOT_EMPTY;
import static com.minibank.loans.infrastructure.utils.Constants.NID_NOT_VALID;

public record LoanRequestDTO(@NotEmpty(message = LOAN_TYPE_NOT_EMPTY) String loanType,
                             @Size(min = 14, max = 14, message = NID_NOT_VALID) String nationalID,
                             @Positive BigDecimal loanAmount) {
}
