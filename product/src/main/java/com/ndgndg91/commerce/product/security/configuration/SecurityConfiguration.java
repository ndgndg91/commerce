package com.ndgndg91.commerce.product.security.configuration;

import com.ndgndg91.commerce.product.security.component.EntryPointUnauthorizedHandler;
import com.ndgndg91.commerce.product.security.component.JWT;
import com.ndgndg91.commerce.product.security.component.JWTAccessDeniedHandler;
import com.ndgndg91.commerce.product.security.component.JWTAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JWTAccessDeniedHandler jwtAccessDeniedHandler;

    private final EntryPointUnauthorizedHandler unauthorizedHandler;

    private final JWT jwt;

    @Bean
    public JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JWTAuthenticationTokenFilter(jwt);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
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
            .authorizeRequests()
              .anyRequest().authenticated()
            .and()
            .formLogin()
              .disable();
        http
            .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
