package org.example.domain.fx.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.fx.exception.errorCode.FXDataErrorCode;

public class FXDataNotFoundException extends GlobalBusinessException {
    public static final FXDataNotFoundException EXCEPTION = new FXDataNotFoundException();

    public FXDataNotFoundException() { super(FXDataErrorCode.FX_DATA_NOT_FOUND); }
}
