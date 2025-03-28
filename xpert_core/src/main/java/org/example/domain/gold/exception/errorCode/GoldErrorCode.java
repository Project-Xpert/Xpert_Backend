package org.example.domain.gold.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum GoldErrorCode implements GlobalErrorCode {
    GOLD_NOT_FOUND(404, "금 데이터를 찾을 수 없습니다.");

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
