package org.example.domain.fx.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.fx.exception.errorCode.FXDataErrorCode;

public class FxNotEnoughException extends GlobalBusinessException {

    public static final FxNotEnoughException EXCEPTION = new FxNotEnoughException();

    public FxNotEnoughException() { super(FXDataErrorCode.FX_NOT_ENOUGH); }
}
