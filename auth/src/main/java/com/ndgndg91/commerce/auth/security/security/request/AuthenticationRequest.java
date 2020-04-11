package com.ndgndg91.commerce.auth.security.security.request;

import com.ndgndg91.commerce.auth.security.member.Email;
import com.ndgndg91.commerce.auth.security.member.MemberIdentifier;
import com.ndgndg91.commerce.auth.security.member.UserName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public final class AuthenticationRequest {
    private final Object principal;
    private final String credentials;

    public MemberIdentifier getPrincipal() {
        if (Email.checkAddress(principal.toString())) {
            return new Email(principal.toString());
        }

        return new UserName(principal.toString());
    }

    public Object getOriginPrincipal(){
        return principal;
    }

    public String getCredentials() {
        return credentials;
    }
}
