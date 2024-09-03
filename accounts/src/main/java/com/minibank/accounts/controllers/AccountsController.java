package com.minibank.accounts.controllers;

import com.minibank.accounts.model.dtos.AccountDTO;
import com.minibank.accounts.model.dtos.CreateAccountDTO;
import com.minibank.accounts.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
@Tag(name = "Bank Management System : Accounts APIs")
public class AccountsController {

    private final AccountService accountService;


    @PostMapping
    @Operation(summary = "Create a new account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody CreateAccountDTO createAccountDto) {
        return ResponseEntity.ok().body(accountService.createAccount(createAccountDto));
    }

    @GetMapping("/{accountNumber}")
    @Operation(summary = "Get Account Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid account number"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    public ResponseEntity<AccountDTO> getAccountDetails(@PathVariable String accountNumber) {
        return ResponseEntity.ok().body(accountService.getAccount(accountNumber));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete an account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Account Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<Object> deleteAccount(@RequestParam("accountNumber") String accountNumber) {
        return ResponseEntity.ok().body(accountService.deleteAccount(accountNumber));
    }
}