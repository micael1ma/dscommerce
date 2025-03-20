package com.micael1ma.dscommerce.controllers.handlers;

import com.micael1ma.dscommerce.dto.CustomError;
import com.micael1ma.dscommerce.dto.ValidationError;
import com.micael1ma.dscommerce.services.execptions.DatabaseException;
import com.micael1ma.dscommerce.services.execptions.ForbiddenException;
import com.micael1ma.dscommerce.services.execptions.ResourceNotFoundExeception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

        @ExceptionHandler(ResourceNotFoundExeception.class)
        public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundExeception e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }

        @ExceptionHandler(DatabaseException.class)
        public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados invalidos", request.getRequestURI());
            for (FieldError f : e.getBindingResult().getFieldErrors()) {
                err.addError(f.getField(), f.getDefaultMessage());
            }
            return ResponseEntity.status(status).body(err);
        }

        @ExceptionHandler(ForbiddenException.class)
        public ResponseEntity<CustomError> forbidden(ForbiddenException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.FORBIDDEN;
            CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }


}

