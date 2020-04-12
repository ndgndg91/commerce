package com.ndgndg91.commerce.auth.security.security.configuration;

import com.ndgndg91.commerce.auth.security.security.component.EntryPointUnauthorizedHandler;
import com.ndgndg91.commerce.auth.security.security.component.JWTAccessDeniedHandler;
import com.ndgndg91.commerce.auth.security.security.component.JWTAuthenticationProvider;
import com.ndgndg91.commerce.auth.security.security.component.JWTAuthenticationTokenFilter;
import com.ndgndg91.commerce.auth.security.security.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

    private final JWTAuthenticationProvider jwtAuthenticationProvider;

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
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider);
        super.configure(auth);
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
//                .antMatchers("/member").permitAll()
                .antMatchers("/sign-in", "/sign-up").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .disable();
        http
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
