package org.example.domain.stock.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum StockHoldingErrorCode implements GlobalErrorCode {
    STOCK_HOLDING_NOT_FOUND(404, "가진 주식 데이터를 찾을 수 없습니다.");

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
