package com.skybooker.SkyBooker.exceptions;

import com.skybooker.SkyBooker.dtos.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CustomAccessDenialHandler implements AccessDeniedHandler {

    private final ObjectMapper mapper;

    public CustomAccessDenialHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Response<?> errorResponse = Response.builder()
                .statusCode(HttpStatus.FORBIDDEN.value()) //403 error
                .message(accessDeniedException.getMessage())
                .build();

        response.setContentType("application/json");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().print(mapper.writeValueAsString(errorResponse));
    }
}
