package org.example.domain.stock.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.stock.exception.errorCode.StockHoldingErrorCode;

public class StockHoldingNotFoundException extends GlobalBusinessException {
    public static final StockHoldingNotFoundException EXCEPTION = new StockHoldingNotFoundException();

    public StockHoldingNotFoundException() { super(StockHoldingErrorCode.STOCK_HOLDING_NOT_FOUND); }
}
