package com.efub.frontSeminar.global.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTest {

    @Test
    void noResourceFoundExceptionReturnsNotFoundResponse() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();
        NoResourceFoundException exception =
                new NoResourceFoundException(HttpMethod.GET, "/missing", "static resource");

        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNoResourceFoundException(exception);

        assertEquals(404, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(404, response.getBody().getStatus());
        assertEquals("RESOURCE_NOT_FOUND", response.getBody().getError());
        assertEquals("요청한 리소스를 찾을 수 없습니다.", response.getBody().getMessage());
    }
}
