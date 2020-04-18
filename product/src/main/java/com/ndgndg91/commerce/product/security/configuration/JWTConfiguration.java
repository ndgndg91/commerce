package com.ndgndg91.commerce.product.security.configuration;

import com.ndgndg91.commerce.product.security.component.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfiguration {

    @Value("${jwt.issuer}") private String issuer;
    @Value("${jwt.client-secret}") private String clientSecret;
    @Value("${jwt.expiry-seconds}") private int expirySeconds;

    @Bean
    public JWT jwt(){
        return new JWT(issuer, clientSecret, expirySeconds);
    }
}