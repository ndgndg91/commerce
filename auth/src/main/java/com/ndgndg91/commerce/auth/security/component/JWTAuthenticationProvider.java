package com.ndgndg91.commerce.auth.security.component;

import com.ndgndg91.commerce.auth.security.member.Member;
import com.ndgndg91.commerce.auth.security.member.service.MemberService;
import com.ndgndg91.commerce.auth.security.security.JWT;
import com.ndgndg91.commerce.auth.security.security.JWTAuthenticationToken;
import com.ndgndg91.commerce.auth.security.security.request.JWTAuthenticateRequest;
import com.ndgndg91.commerce.auth.security.security.response.JWTAuthenticateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class JWTAuthenticationProvider implements AuthenticationProvider {

    private final JWT jwt;
    private final MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JWTAuthenticationToken jwtAuthenticationToken = (JWTAuthenticationToken) authentication;
        JWTAuthenticateRequest jwtAuthenticateRequest = jwtAuthenticationToken.toRequest();

        return null;
    }

    private JWTAuthenticateResponse processAuthenticate(JWTAuthenticateRequest jwtAuthenticateRequest){
        Member loginMember = memberService.login(jwtAuthenticateRequest.getPrincipal(), jwtAuthenticateRequest.getCredentials());
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
