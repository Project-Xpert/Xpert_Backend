package org.example.domain.fx.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.common.exception.GlobalErrorCode;
import org.example.domain.fx.exception.errorCode.FXDataErrorCode;

public class FxNotFoundException extends GlobalBusinessException {
    public static final FxNotFoundException EXCEPTION = new FxNotFoundException();

    public FxNotFoundException() { super(FXDataErrorCode.FX_NOT_FOUND); }
}
