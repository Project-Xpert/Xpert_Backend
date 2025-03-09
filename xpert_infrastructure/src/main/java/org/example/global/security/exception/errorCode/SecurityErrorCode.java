package org.example.global.security.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum SecurityErrorCode implements GlobalErrorCode {
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다"),
    TOKEN_EXPIRED(401, "토큰이 만료되었습니다");

    private final int errorCode;
    private final String errorMessage;

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
