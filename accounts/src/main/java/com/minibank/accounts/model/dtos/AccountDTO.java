package com.minibank.accounts.model.dtos;

import com.minibank.accounts.model.enums.AccountStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Schema(
        name = "Account",
        description = "This schema represents the data transfer object for an account"
)
public record AccountDTO(
        @Schema(example = "ACC-*************")
        String accountNumber,
        LocalDateTime openingDate,
        BigDecimal availableBalance,
        String accountType,
        AccountStatus accountStatus, Long userId) {
}