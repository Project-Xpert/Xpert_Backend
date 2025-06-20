package org.example.domain.stock.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.stock.exception.errorCode.StockPriceErrorCode;

public class StockPriceNotFoundException extends GlobalBusinessException {
    public static final StockPriceNotFoundException EXCEPTION = new StockPriceNotFoundException();
    public StockPriceNotFoundException() { super(StockPriceErrorCode.STOCK_PRICE_NOT_FOUND); }
}
