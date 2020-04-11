package com.ndgndg91.commerce.auth.security.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiFailResult implements ApiResponse {
    @Getter
    private String message;

    public static ApiFailResult forbidden(){
        return new ApiFailResult("권한 없음");
    }

    public static ApiFailResult unAuthorize(){
        return new ApiFailResult("인증 되지 않음");
    }
}
