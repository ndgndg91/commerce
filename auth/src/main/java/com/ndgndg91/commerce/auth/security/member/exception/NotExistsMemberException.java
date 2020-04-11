package com.ndgndg91.commerce.auth.security.member.exception;

public class NotExistsMemberException extends RuntimeException {
    public NotExistsMemberException() {
    }

    public NotExistsMemberException(String message) {
        super(message);
    }
}
