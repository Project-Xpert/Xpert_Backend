package org.example.domain.stock.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.stock.exception.errorCode.StockErrorCode;

public class StockNotFoundException extends GlobalBusinessException {
    public static final StockNotFoundException EXCEPTION = new StockNotFoundException();
    public StockNotFoundException() { super(StockErrorCode.STOCK_NOT_FOUND); }
}
