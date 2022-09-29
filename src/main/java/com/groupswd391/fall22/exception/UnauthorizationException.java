package com.groupswd391.fall22.exception;

public class UnauthorizationException extends RuntimeException{

    public UnauthorizationException() {
        super();
    }

    public UnauthorizationException(String message) {
        super(message);
    }

    public UnauthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizationException(Throwable cause) {
        super(cause);
    }
}
