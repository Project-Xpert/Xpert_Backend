package org.example.global.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.common.exception.GlobalErrorCode;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalBusinessException.class)
    public final ResponseEntity<ErrorResponse> handleGlobalBusinessException(GlobalBusinessException e) {
        GlobalErrorCode errorCode = e.errorCode;
        ErrorResponse response = ErrorResponse.of(errorCode);

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getErrorCode()));
    }
}
