package com.ndgndg91.commerce.product.security.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiFailResult implements ApiResponse {
    private static final ApiFailResult FORBIDDEN = new ApiFailResult("권한 없음");
    private static final ApiFailResult UN_AUTHORIZE = new ApiFailResult("인증 되지 않음");

    @Getter
    private String message;

    public static ApiFailResult forbidden(){
        return FORBIDDEN;
    }

    public static ApiFailResult unAuthorize(){
        return UN_AUTHORIZE;
    }

    public static ApiFailResult invalidPassword(String message) { return new ApiFailResult(message);}

    public static ApiFailResult notExistMember(String message) { return new ApiFailResult(message);}

    public static ApiFailResult msg(String message) {
        return new ApiFailResult(message);
    }
}
