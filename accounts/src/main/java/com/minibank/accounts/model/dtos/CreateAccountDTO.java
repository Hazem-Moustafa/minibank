package com.minibank.accounts.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

import static com.minibank.accounts.infrastructure.utils.Constants.AVAILABLE_BALANCE_NOT_GREATER_THAN_ZERO;


@Builder
@Schema(name = "CreateAccountInfo", description = "Information required to create an account")
public record CreateAccountDTO(
        @Schema(description = "ID of the user")
        Long userId,

        @Schema(description = "Type of the account",example = "SAVINGS")
        String accountType,

        @Schema(description = "Initial available balance", required = true)
        @Positive(message = AVAILABLE_BALANCE_NOT_GREATER_THAN_ZERO)
        BigDecimal availableBalance) {
}