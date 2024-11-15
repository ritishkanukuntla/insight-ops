package com.example.hack24;

import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

    @Resource
    private Hack24ConfigurationProperties hack24ConfigurationProperties;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGlobalException(Exception ex, WebRequest request) throws Exception {
        if(ex instanceof NoResourceFoundException){
            return new ResponseEntity<>(
                    new Response(
                            hack24ConfigurationProperties.getApplicationVersion(),
                            ex.getMessage()),
                    Utils.getResponseHeaders(hack24ConfigurationProperties),
                    HttpStatus.NOT_FOUND);
        }
        if(ex instanceof RuntimeException) {
            return new ResponseEntity<>(
                    new Response(
                            hack24ConfigurationProperties.getApplicationVersion(),
                            ex.getMessage()),
                    Utils.getResponseHeaders(hack24ConfigurationProperties),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        throw ex;
    }
}