package com.ndgndg91.commerce.auth.security.security;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ndgndg91.commerce.auth.security.member.Email;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public final class JWT {
    private String issuer;
    private String clientSecret;
    private int expirySeconds;
    private Algorithm algorithm;
    private JWTVerifier jwtVerifier;

    public JWT(String issuer, String clientSecret, int expirySeconds) {
        this.issuer = issuer;
        this.clientSecret = clientSecret;
        this.expirySeconds = expirySeconds;
        this.algorithm = Algorithm.HMAC512(clientSecret);
        this.jwtVerifier = com.auth0.jwt.JWT.require(algorithm)
                .withIssuer(issuer)
                .build();
    }

    public String newToken(Claims claims) {
        Date now = new Date();
        JWTCreator.Builder builder = com.auth0.jwt.JWT.create();
        builder.withIssuer(issuer);
        builder.withIssuedAt(now);
        if (expirySeconds > 0) {
            builder.withExpiresAt(new Date(now.getTime() + expirySeconds * 1_000L));
        }
        builder.withClaim("userKey", claims.userKey);
        builder.withClaim("name", claims.name);
        builder.withClaim("email", claims.email.getAddress());
        builder.withArrayClaim("roles", claims.roles);
        return builder.sign(algorithm);
    }

    public String refreshToken(String token) {
        Claims claims = verify(token);
        claims.eraseIat();
        claims.eraseExp();
        return newToken(claims);
    }

    public Claims verify(String token) {
        return new Claims(jwtVerifier.verify(token));
    }

    public String getIssuer() {
        return issuer;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public int getExpirySeconds() {
        return expirySeconds;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public JWTVerifier getJwtVerifier() {
        return jwtVerifier;
    }

    public static class Claims {
        private Long userKey;
        private String name;
        private Email email;
        private String[] roles;
        private Date iat;
        private Date exp;

        private Claims() {}

        Claims(DecodedJWT decodedJWT) {
            Claim userKeyClaim = decodedJWT.getClaim("userKey");
            if (!userKeyClaim.isNull())
                this.userKey = userKeyClaim.asLong();
            Claim nameClaim = decodedJWT.getClaim("name");
            if (!nameClaim.isNull())
                this.name = nameClaim.asString();
            Claim emailClaim = decodedJWT.getClaim("email");
            if (!emailClaim.isNull())
                this.email = new Email(emailClaim.asString());
            Claim rolesClaim = decodedJWT.getClaim("roles");
            if (!rolesClaim.isNull())
                this.roles = rolesClaim.asArray(String.class);
            this.iat = decodedJWT.getIssuedAt();
            this.exp = decodedJWT.getExpiresAt();
        }

        public static Claims of(long userKey, String name, Email email, String[] roles) {
            Claims claims = new Claims();
            claims.userKey = userKey;
            claims.name = name;
            claims.email = email;
            claims.roles = roles;
            return claims;
        }

        public Long getUserKey() {
            return userKey;
        }

        public String getName() {
            return name;
        }

        public Email getEmail() {
            return email;
        }

        public String[] getRoles() {
            return roles;
        }

        public long iat() {
            return iat != null ? iat.getTime() : -1;
        }

        public long exp() {
            return exp != null ? exp.getTime() : -1;
        }

        public void eraseIat() {
            iat = null;
        }

        public void eraseExp() {
            exp = null;
        }

        @Override
        public String toString() {
            return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .toString();
        }
    }
}
