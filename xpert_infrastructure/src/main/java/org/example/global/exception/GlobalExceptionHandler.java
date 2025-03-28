package org.example.global.exception;

import org.example.common.exception.general.GeneralExceptionCode;
import org.example.common.exception.GlobalBusinessException;
import org.example.common.exception.GlobalErrorCode;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalBusinessException.class)
    public final ResponseEntity<ErrorResponse> handleGlobalBusinessException(GlobalBusinessException e) {
        GlobalErrorCode errorCode = e.errorCode;
        ErrorResponse response = ErrorResponse.of(errorCode);

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getErrorCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String description = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorResponse response = ErrorResponse.of(GeneralExceptionCode.BAD_REQUEST, description);

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ErrorResponse response = ErrorResponse.of(GeneralExceptionCode.BAD_REQUEST, "request body가 없습니다.");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
    }
}
