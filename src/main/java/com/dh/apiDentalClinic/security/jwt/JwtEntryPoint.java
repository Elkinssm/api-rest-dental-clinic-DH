package com.dh.apiDentalClinic.security.jwt;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

     private final  static  Logger logger = Logger.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, @NotNull HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fail in the method commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Noth authorized");
    }
}
