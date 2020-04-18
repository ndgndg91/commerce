package com.ndgndg91.commerce.product.security.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public final class AuthenticationRequest {
    private final Object principal;
    private final String credentials;

    public Object getOriginPrincipal(){
        return principal;
    }

    public String getCredentials() {
        return credentials;
    }
}
