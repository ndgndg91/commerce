package com.ndgndg91.commerce.auth.security.security.response;

import com.ndgndg91.commerce.auth.security.member.Member;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
public class AuthenticationResult {
    private final String token;

    private final Member member;

    public AuthenticationResult(String apiToken, Member member) {
        checkNotNull(apiToken, "apiToken must be provided.");
        checkNotNull(member, "user must be provided.");

        this.token = apiToken;
        this.member = member;
    }
}
