package com.ndgndg91.commerce.auth.security.auth.controller;

import com.ndgndg91.commerce.auth.security.auth.exception.UnauthorizedException;
import com.ndgndg91.commerce.auth.security.security.JWTAuthenticationToken;
import com.ndgndg91.commerce.auth.security.security.request.AuthenticationRequest;
import com.ndgndg91.commerce.auth.security.security.response.AuthenticationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/sign-in")
    public AuthenticationResult authentication(@RequestBody AuthenticationRequest authRequest) throws UnauthorizedException {
        try {
            JWTAuthenticationToken authToken = new JWTAuthenticationToken(authRequest.getOriginPrincipal(), authRequest.getCredentials());
            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return (AuthenticationResult) authentication.getDetails();
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(e.getMessage());
        }
    }
}
