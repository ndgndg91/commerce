package com.ndgndg91.commerce.product.common;

import com.ndgndg91.commerce.product.exception.NotFoundException;
import com.ndgndg91.commerce.product.security.domain.ApiFailResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiFailResult> notFoundError() {
        return ResponseEntity.ok(ApiFailResult.msg("존재 하지 않습니다."));
    }
}
