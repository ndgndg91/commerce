package com.ndgndg91.commerce.auth.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndgndg91.commerce.auth.security.common.ApiFailResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAccessDeniedHandler implements AccessDeniedHandler {

    private static final ApiFailResult FORBIDDEN = ApiFailResult.forbidden();

    private final ObjectMapper om;

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException e) throws IOException, ServletException {
        res.setStatus(HttpServletResponse.SC_FORBIDDEN);
        res.setHeader("content-type", "application/json;charset=utf8;");
        res.getWriter().write(om.writeValueAsString(FORBIDDEN));
        res.getWriter().flush();
        res.getWriter().close();
    }
}
