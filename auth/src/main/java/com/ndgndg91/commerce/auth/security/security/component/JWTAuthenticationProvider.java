package com.ndgndg91.commerce.auth.security.security.component;

import com.ndgndg91.commerce.auth.security.member.Member;
import com.ndgndg91.commerce.auth.security.member.service.MemberService;
import com.ndgndg91.commerce.auth.security.security.JWT;
import com.ndgndg91.commerce.auth.security.security.JWTAuthenticationToken;
import com.ndgndg91.commerce.auth.security.security.Role;
import com.ndgndg91.commerce.auth.security.security.request.AuthenticationRequest;
import com.ndgndg91.commerce.auth.security.security.response.AuthenticationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.ClassUtils.isAssignable;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationProvider implements AuthenticationProvider {

    private final JWT jwt;
    private final MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) {
        JWTAuthenticationToken jwtAuthenticationToken = (JWTAuthenticationToken) authentication;
        AuthenticationRequest jwtAuthenticateRequest = jwtAuthenticationToken.toRequest();
        return processAuthenticate(jwtAuthenticateRequest);
    }

    private JWTAuthenticationToken processAuthenticate(AuthenticationRequest jwtAuthenticateRequest) {
        Member loginMember = memberService.login(jwtAuthenticateRequest.getPrincipal(), jwtAuthenticateRequest.getCredentials());
        JWTAuthenticationToken authenticated = new JWTAuthenticationToken(loginMember.getMemberNo(), null, createAuthorityList(Role.USER.name()));
        String token = loginMember.newApiToken(jwt, new String[]{Role.USER.name()});
        authenticated.setDetails(new AuthenticationResult(token, loginMember));
        return authenticated;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return isAssignable(JWTAuthenticationToken.class, authentication);
    }
}
