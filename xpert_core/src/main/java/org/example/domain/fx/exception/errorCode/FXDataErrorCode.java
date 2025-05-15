package org.example.domain.fx.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum FXDataErrorCode implements GlobalErrorCode {
    FX_NOT_FOUND(404, "소지 외화 데이터를 찾을 수 없습니다."),
    FX_DATA_NOT_FOUND(404, "FX 데이터를 찾을 수 없습니다."),
    FX_NOT_ENOUGH(409, "거래에 필요한 외화가 충분하지 않습니다.");

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
