package org.example.global.thirdparty.mail.exception;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum MailErrorCode implements GlobalErrorCode {
    EMAIL_NOT_VALID(400, "이메일 주소가 유효하지 않습니다");

    private final int errorCode;
    private final String errorMessage;

    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
