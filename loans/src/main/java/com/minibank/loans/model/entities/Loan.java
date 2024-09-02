package com.minibank.loans.model.entities;

import com.minibank.loans.model.enums.LoanType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loans")
public class Loan extends Auditable{

    private String nationalId;
    private BigDecimal loanAmount;
    private Integer term;
    private Double interestRate;
    @Enumerated(EnumType.STRING)
    private LoanType accountType;
    @CreationTimestamp
    private LocalDateTime loanDate;
    private String propertyAddress;
    private BigDecimal propertyValue;
    private Long userId;
}
