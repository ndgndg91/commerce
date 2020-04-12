package com.ndgndg91.commerce.auth.security.security.response;

import com.ndgndg91.commerce.auth.security.member.Member;
import com.ndgndg91.commerce.auth.security.member.response.MemberToFront;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
public class AuthenticationResult {
    private final String token;

    private final MemberToFront member;

    public AuthenticationResult(String apiToken, Member member) {
        checkNotNull(apiToken, "apiToken must be provided.");
        checkNotNull(member, "user must be provided.");
        member.omitPassword();

        this.token = apiToken;
        this.member = MemberToFront.transform(member);
    }
}
