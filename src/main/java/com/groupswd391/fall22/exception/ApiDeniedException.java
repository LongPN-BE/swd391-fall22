package com.groupswd391.fall22.exception;

public class ApiDeniedException extends RuntimeException{

    public ApiDeniedException(String message) {
        super(message);
    }

    public ApiDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
