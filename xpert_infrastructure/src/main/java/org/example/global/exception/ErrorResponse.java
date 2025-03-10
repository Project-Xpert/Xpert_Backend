package org.example.global.exception;

import org.example.common.exception.GlobalErrorCode;

import java.time.LocalDateTime;

public record ErrorResponse (
   int code,
   String message,
   String description,
   LocalDateTime timeStamp
) {
    public static ErrorResponse of(GlobalErrorCode e) {
        return new ErrorResponse(
                e.getErrorCode(),
                e.getErrorMessage(),
                e.getErrorMessage(),
                LocalDateTime.now()
        );
    }

    public static ErrorResponse of(GlobalErrorCode e, String description) {
        return new ErrorResponse(
                e.getErrorCode(),
                e.getErrorMessage(),
                description,
                LocalDateTime.now()
        );
    }
}
