package com.ndgndg91.commerce.auth.security.security.request;

import com.ndgndg91.commerce.auth.security.member.MemberIdentifier;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public final class JWTAuthenticateRequest {
    private final Object principal;
    private final String credentials;

    public MemberIdentifier getPrincipal() {
        return (MemberIdentifier) principal;
    }

    public String getCredentials() {
        return credentials;
    }
}
