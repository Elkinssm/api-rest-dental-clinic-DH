package com.dh.apiDentalClinic.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allErrors(Exception ex, WebRequest req) {
        logger.error(ex.getMessage());
       //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()+ "Error... "+this.getClass().getName()+" de manera global");

     return new ResponseEntity<>("Error " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
