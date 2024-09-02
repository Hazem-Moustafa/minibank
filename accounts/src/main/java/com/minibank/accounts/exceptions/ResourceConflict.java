package com.minibank.accounts.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceConflict extends GlobalException{

    public ResourceConflict() {
        super(HttpStatus.CONFLICT.value(),"Account already exists");
    }

    public ResourceConflict(String message) {
        super(HttpStatus.CONFLICT.value(),message);
    }
}
