package com.ndgndg91.commerce.auth.security.security;

import com.ndgndg91.commerce.auth.security.member.Email;

import static com.google.common.base.Preconditions.checkNotNull;

public class JWTAuthentication {
    public final long memberNo;

    public final String userName;

    public final Email email;

    public JWTAuthentication(Long id, String name, Email email) {
        checkNotNull(id, "id must be provided.");
        checkNotNull(name, "name must be provided.");
        checkNotNull(email, "email must be provided.");

        this.memberNo = id;
        this.userName = name;
        this.email = email;
    }
}
