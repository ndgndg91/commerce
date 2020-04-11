package com.ndgndg91.commerce.auth.security.configuration;

import com.ndgndg91.commerce.auth.security.component.EntryPointUnauthorizedHandler;
import com.ndgndg91.commerce.auth.security.security.JWT;
import com.ndgndg91.commerce.auth.security.component.JWTAccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JWTAccessDeniedHandler jwtAccessDeniedHandler;

    private final EntryPointUnauthorizedHandler unauthorizedHandler;

    private final DataSource dataSource;

    @Value("${jwt.issuer}") private String issuer;
    @Value("${jwt.clientSecret}") private String clientSecret;
    @Value("${jwt.expirySeconds}") private int expirySeconds;

    @Bean
    public JWT jwt(){
        return new JWT(issuer, clientSecret, expirySeconds);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .headers()
                .disable()
            .exceptionHandling()
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//            .authenticationProvider()
            .authorizeRequests()
                .antMatchers("/member").permitAll()
                .antMatchers("/sign-in", "/sign-up").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .disable();
    }

}
