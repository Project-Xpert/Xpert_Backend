package org.example.domain.stock.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.stock.exception.errorCode.StockHoldingErrorCode;

public class NotEnoughStockException extends GlobalBusinessException {
    public static final NotEnoughStockException EXCEPTION = new NotEnoughStockException();

    public NotEnoughStockException() {
        super(StockHoldingErrorCode.NOT_ENOUGH_STOCK);
    }
}
