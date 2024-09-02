package com.minibank.loans.exceptions;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private final int errorCode;

    private final String errorMessage;

}
