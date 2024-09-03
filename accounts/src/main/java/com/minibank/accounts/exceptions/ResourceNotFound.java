package com.minibank.accounts.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFound extends GlobalException{

    public ResourceNotFound() {
        super(HttpStatus.NOT_FOUND.value(),"Resource not found on the server");
    }

    public ResourceNotFound(String message) {
        super(HttpStatus.NOT_FOUND.value(),message);
    }
}
