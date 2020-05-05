package com.ndgndg91.commerce.auth.security.common;

import com.ndgndg91.commerce.auth.security.auth.exception.UnauthorizedException;
import com.ndgndg91.commerce.auth.security.member.exception.DuplicateMemberException;
import com.ndgndg91.commerce.auth.security.member.exception.InvalidPasswordException;
import com.ndgndg91.commerce.auth.security.member.exception.NotExistsMemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthenticationAdviser {

    @ExceptionHandler(NotExistsMemberException.class)
    public ResponseEntity<ApiFailResult> notExistsMember(NotExistsMemberException e) {
        return ResponseEntity.status(400).body(ApiFailResult.notExistMember(e.getMessage()));
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ApiFailResult> invalidPassword(InvalidPasswordException e){
        return ResponseEntity.status(401).body(ApiFailResult.invalidPassword(e.getMessage()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiFailResult> unauthorized(UnauthorizedException e) {
        return ResponseEntity.status(401).body(ApiFailResult.unAuthorize());
    }

    @ExceptionHandler(DuplicateMemberException.class)
    public ResponseEntity<ApiFailResult> duplicateError(DuplicateMemberException e) {
        return ResponseEntity.status(400).body(ApiFailResult.msg(e.getMessage()));
    }
}
