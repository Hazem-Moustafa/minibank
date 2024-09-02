package com.minibank.accounts.services.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.minibank.accounts.exceptions.ResourceNotFound;
import com.minibank.accounts.model.dtos.AccountDTO;
import com.minibank.accounts.model.dtos.CreateAccountDTO;
import com.minibank.accounts.model.entities.Account;
import com.minibank.accounts.model.enums.AccountStatus;
import com.minibank.accounts.model.enums.AccountType;
import com.minibank.accounts.model.mappers.AccountMapper;
import com.minibank.accounts.model.repos.AccountRepo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AccountServiceImplDiffblueTest {
    @MockBean
    private AccountMapper accountMapper;

    @MockBean
    private AccountRepo accountRepo;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    /**
     * Method under test: {@link AccountServiceImpl#createAccount(CreateAccountDTO)}
     */
    @Test
    void testCreateAccount() {
        // Arrange
        Account account = new Account();
        account.setAccountNumber("42");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVINGS);
        account.setAccountUuid(UUID.randomUUID());
        account.setAvailableBalance(new BigDecimal("2.3"));
        account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setCreatedBy(1L);
        account.setDeleted(true);
        account.setId(1L);
        account.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedBy(1L);
        account.setUserId(1L);
        account.setUsername("janedoe");
        LocalDateTime openingDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        AccountDTO accountDTO = new AccountDTO("42", openingDate, new BigDecimal("2.3"), "3", AccountStatus.ACTIVE, 1L);

        when(accountMapper.convertToDto(Mockito.<Account>any(), isA(Object[].class))).thenReturn(accountDTO);
        when(accountMapper.convertToEntity(Mockito.<Object>any(), isA(Object[].class))).thenReturn(account);

        Account account2 = new Account();
        account2.setAccountNumber("42");
        account2.setAccountStatus(AccountStatus.ACTIVE);
        account2.setAccountType(AccountType.SAVINGS);
        account2.setAccountUuid(UUID.randomUUID());
        account2.setAvailableBalance(new BigDecimal("2.3"));
        account2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account2.setCreatedBy(1L);
        account2.setDeleted(true);
        account2.setId(1L);
        account2.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account2.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account2.setUpdatedBy(1L);
        account2.setUserId(1L);
        account2.setUsername("janedoe");
        when(accountRepo.save(Mockito.<Account>any())).thenReturn(account2);

        // Act
        AccountDTO actualCreateAccountResult = accountServiceImpl
                .createAccount(new CreateAccountDTO(1L, "3", new BigDecimal("2.3")));

        // Assert
        verify(accountMapper).convertToDto(isA(Account.class), isA(Object[].class));
        verify(accountMapper).convertToEntity(isA(Object.class), isA(Object[].class));
        verify(accountRepo).save(isA(Account.class));
        assertSame(accountDTO, actualCreateAccountResult);
    }

    /**
     * Method under test: {@link AccountServiceImpl#createAccount(CreateAccountDTO)}
     */
    @Test
    void testCreateAccount2() {
        // Arrange
        Account account = new Account();
        account.setAccountNumber("42");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVINGS);
        account.setAccountUuid(UUID.randomUUID());
        account.setAvailableBalance(new BigDecimal("2.3"));
        account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setCreatedBy(1L);
        account.setDeleted(true);
        account.setId(1L);
        account.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedBy(1L);
        account.setUserId(1L);
        account.setUsername("janedoe");
        when(accountMapper.convertToEntity(Mockito.<Object>any(), isA(Object[].class))).thenReturn(account);
        when(accountRepo.save(Mockito.<Account>any())).thenThrow(new ResourceNotFound());

        // Act and Assert
        assertThrows(ResourceNotFound.class,
                () -> accountServiceImpl.createAccount(new CreateAccountDTO(1L, "3", new BigDecimal("2.3"))));
        verify(accountMapper).convertToEntity(isA(Object.class), isA(Object[].class));
        verify(accountRepo).save(isA(Account.class));
    }

    /**
     * Method under test: {@link AccountServiceImpl#getAccount(String)}
     */
    @Test
    void testGetAccount() {
        // Arrange
        LocalDateTime openingDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        AccountDTO accountDTO = new AccountDTO("42", openingDate, new BigDecimal("2.3"), "3", AccountStatus.ACTIVE, 1L);

        when(accountMapper.convertToDto(Mockito.<Account>any(), isA(Object[].class))).thenReturn(accountDTO);

        Account account = new Account();
        account.setAccountNumber("42");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVINGS);
        account.setAccountUuid(UUID.randomUUID());
        account.setAvailableBalance(new BigDecimal("2.3"));
        account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setCreatedBy(1L);
        account.setDeleted(true);
        account.setId(1L);
        account.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedBy(1L);
        account.setUserId(1L);
        account.setUsername("janedoe");
        Optional<Account> ofResult = Optional.of(account);
        when(accountRepo.findAccountByAccountNumber(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        AccountDTO actualAccount = accountServiceImpl.getAccount("42");

        // Assert
        verify(accountMapper).convertToDto(isA(Account.class), isA(Object[].class));
        verify(accountRepo).findAccountByAccountNumber(eq("42"));
        assertSame(accountDTO, actualAccount);
    }

    /**
     * Method under test: {@link AccountServiceImpl#getAccount(String)}
     */
    @Test
    void testGetAccount2() {
        // Arrange
        when(accountMapper.convertToDto(Mockito.<Account>any(), isA(Object[].class))).thenThrow(new ResourceNotFound());

        Account account = new Account();
        account.setAccountNumber("42");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVINGS);
        account.setAccountUuid(UUID.randomUUID());
        account.setAvailableBalance(new BigDecimal("2.3"));
        account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setCreatedBy(1L);
        account.setDeleted(true);
        account.setId(1L);
        account.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedBy(1L);
        account.setUserId(1L);
        account.setUsername("janedoe");
        Optional<Account> ofResult = Optional.of(account);
        when(accountRepo.findAccountByAccountNumber(Mockito.<String>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> accountServiceImpl.getAccount("42"));
        verify(accountMapper).convertToDto(isA(Account.class), isA(Object[].class));
        verify(accountRepo).findAccountByAccountNumber(eq("42"));
    }

    /**
     * Method under test: {@link AccountServiceImpl#deleteAccount(String)}
     */
    @Test
    void testDeleteAccount() {
        // Arrange
        Account account = new Account();
        account.setAccountNumber("42");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVINGS);
        account.setAccountUuid(UUID.randomUUID());
        account.setAvailableBalance(new BigDecimal("2.3"));
        account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setCreatedBy(1L);
        account.setDeleted(true);
        account.setId(1L);
        account.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedBy(1L);
        account.setUserId(1L);
        account.setUsername("janedoe");
        Optional<Account> ofResult = Optional.of(account);
        when(accountRepo.deleteByAccountNumber(Mockito.<String>any())).thenReturn(true);
        when(accountRepo.findAccountByAccountNumber(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        boolean actualDeleteAccountResult = accountServiceImpl.deleteAccount("42");

        // Assert
        verify(accountRepo).deleteByAccountNumber(eq("42"));
        verify(accountRepo).findAccountByAccountNumber(eq("42"));
        assertTrue(actualDeleteAccountResult);
    }

    /**
     * Method under test: {@link AccountServiceImpl#deleteAccount(String)}
     */
    @Test
    void testDeleteAccount2() {
        // Arrange
        Account account = new Account();
        account.setAccountNumber("42");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVINGS);
        account.setAccountUuid(UUID.randomUUID());
        account.setAvailableBalance(new BigDecimal("2.3"));
        account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setCreatedBy(1L);
        account.setDeleted(true);
        account.setId(1L);
        account.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedBy(1L);
        account.setUserId(1L);
        account.setUsername("janedoe");
        Optional<Account> ofResult = Optional.of(account);
        when(accountRepo.deleteByAccountNumber(Mockito.<String>any())).thenThrow(new ResourceNotFound());
        when(accountRepo.findAccountByAccountNumber(Mockito.<String>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> accountServiceImpl.deleteAccount("42"));
        verify(accountRepo).deleteByAccountNumber(eq("42"));
        verify(accountRepo).findAccountByAccountNumber(eq("42"));
    }

    /**
     * Method under test: {@link AccountServiceImpl#deleteAccount(String)}
     */
    @Test
    void testDeleteAccount3() {
        // Arrange
        Account account = new Account();
        account.setAccountNumber("42");
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setAccountType(AccountType.SAVINGS);
        account.setAccountUuid(UUID.randomUUID());
        account.setAvailableBalance(new BigDecimal("2.3"));
        account.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setCreatedBy(1L);
        account.setDeleted(true);
        account.setId(1L);
        account.setOpeningDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        account.setUpdatedBy(1L);
        account.setUserId(1L);
        account.setUsername("janedoe");
        Optional<Account> ofResult = Optional.of(account);
        when(accountRepo.deleteByAccountNumber(Mockito.<String>any())).thenReturn(false);
        when(accountRepo.findAccountByAccountNumber(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        boolean actualDeleteAccountResult = accountServiceImpl.deleteAccount("42");

        // Assert
        verify(accountRepo).deleteByAccountNumber(eq("42"));
        verify(accountRepo).findAccountByAccountNumber(eq("42"));
        assertFalse(actualDeleteAccountResult);
    }
}
