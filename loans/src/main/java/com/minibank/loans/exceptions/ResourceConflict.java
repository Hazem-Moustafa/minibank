package com.minibank.loans.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceConflict extends GlobalException{

    public ResourceConflict() {
        super(HttpStatus.CONFLICT.value(),"Resource already exists");
    }

    public ResourceConflict(String message) {
        super(HttpStatus.CONFLICT.value(),message);
    }
}
