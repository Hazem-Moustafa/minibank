package com.minibank.loans.model.dtos;

import java.math.BigDecimal;

public record LoanDTO(String loanType,
                      String nationalID,
                      BigDecimal loanAmount,
                      Double interestRate,
                      Integer term,
                      BigDecimal dueAmount) {
}
