package org.example.domain.account.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum AccountErrorCode implements GlobalErrorCode {
    NOT_OWNER_OF_ACCOUNT(403, "계좌의 소유자가 아닙니다."),
    ACCOUNT_NOT_FOUND(404, "계좌 정보를 찾을 수 없습니다.");

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
