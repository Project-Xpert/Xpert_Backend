package org.example.common.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GlobalBusinessException extends RuntimeException {
    public final GlobalErrorCode errorCode;
}
