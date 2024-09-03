package com.minibank.accounts.model.entities;

import com.minibank.accounts.model.enums.AccountStatus;
import com.minibank.accounts.model.enums.AccountType;
import com.minibank.accounts.model.listeners.AccountListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AccountListener.class)
@Table(name = "Accounts")
public class Account extends Auditable {

    @Column(unique = true, nullable = false, updatable = false)
    private UUID accountUuid;

    @Column(unique = true, nullable = false, updatable = false)
    private String accountNumber;

    private String username;

    @CreationTimestamp
    private LocalDateTime openingDate;

    private BigDecimal availableBalance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private Long userId;

}
