package com.minibank.accounts.model.mappers;

import com.minibank.accounts.model.dtos.AccountDTO;
import com.minibank.accounts.model.dtos.CreateAccountDTO;
import com.minibank.accounts.model.entities.Account;
import com.minibank.accounts.model.enums.AccountStatus;
import com.minibank.accounts.model.enums.AccountType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class AccountMapper extends BaseMapper<Account, Object> {
    @Override
    public Account convertToEntity(Object dto, Object... args) {
        Account account = new Account();
        if (!Objects.isNull(dto)) {
            BeanUtils.copyProperties(dto, account);

            if (dto instanceof CreateAccountDTO accountDTO && accountDTO.accountType() != null) {
                try {
                    account.setAccountType(AccountType.valueOf(accountDTO.accountType()));
                    account.setAccountStatus(AccountStatus.ACTIVE);
                } catch (IllegalArgumentException e) {
                    log.info("You have not appropriate Account Type to be mapped");
                    account.setAccountStatus(AccountStatus.INACTIVE);
                }
            }

        }
        return account;
    }

    @Override
    public AccountDTO convertToDto(Account entity, Object... args) {

        return AccountDTO.builder()
                .accountType(entity.getAccountType().toString())
                .accountStatus(entity.getAccountStatus())
                .openingDate(entity.getOpeningDate())
                .accountNumber(entity.getAccountNumber())
                .availableBalance(entity.getAvailableBalance())
                .userId(entity.getUserId())
                .build();
    }
}
