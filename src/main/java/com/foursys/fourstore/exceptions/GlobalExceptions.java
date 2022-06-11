package com.foursys.fourstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundHandlerMethod(EntityNotFoundException ex, HttpServletRequest request) {
        StandardError se = new StandardError(Instant.now(), 404, "Entity not found", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
    }

    @ExceptionHandler(UnreportedEssentialFieldException.class)
    public ResponseEntity<StandardError> unreportedEssentialFieldHandlerMethod(UnreportedEssentialFieldException ex, HttpServletRequest request) {
        StandardError se = new StandardError(Instant.now(), 422, "Unreported essential field", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(se);
    }

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<StandardError> InvalidValueHandlerMethod(InvalidValueException ex, HttpServletRequest request) {
        StandardError se = new StandardError(Instant.now(), 400, "Invalid value field", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }
}