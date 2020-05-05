package com.ndgndg91.commerce.auth.security.member.exception;

public class DuplicateMemberException extends RuntimeException {
    public DuplicateMemberException() {
    }

    public DuplicateMemberException(String message) {
        super(message);
    }
}
