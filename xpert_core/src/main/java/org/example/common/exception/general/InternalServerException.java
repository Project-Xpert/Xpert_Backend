package org.example.common.exception.general;

import org.example.common.exception.GlobalBusinessException;

public class InternalServerException extends GlobalBusinessException {
    public static final InternalServerException EXCEPTION = new InternalServerException();

    public InternalServerException() { super(GeneralExceptionCode.INTERNAL_SERVER_ERROR); }
}
