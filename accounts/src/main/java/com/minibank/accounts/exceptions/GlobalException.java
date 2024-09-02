package com.minibank.accounts.exceptions;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private final int errorCode;

    private final String errorMessage;

}
