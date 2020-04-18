package com.ndgndg91.commerce.product.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndgndg91.commerce.product.security.domain.ApiFailResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    private static final ApiFailResult UN_AUTHORIZE = ApiFailResult.unAuthorize();

    private final ObjectMapper om;

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.setHeader("content-type", "application/json;charset=utf8;");
        res.getWriter().write(om.writeValueAsString(UN_AUTHORIZE));
        res.getWriter().flush();
        res.getWriter().close();
    }
}
