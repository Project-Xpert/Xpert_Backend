package org.example.domain.user.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum UserErrorCode implements GlobalErrorCode {
    USER_NOT_FOUND(404, "유저를 찾지 못했습니다"),
    CODE_NOT_MATCHES(401, "인증코드가 맞지 않습니다"),
    RUN_OUT_OF_MONEY(409, "돈이 부족합니다"),
    USER_ID_ALREADY_EXISTS(409, "이미 해당 아이디로 가입된 유저가 존재합니다"),
    EMAIL_ALREADY_EXISTS(409, "이미 해당 이메일로 가입된 유저가 존재합니다");

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
