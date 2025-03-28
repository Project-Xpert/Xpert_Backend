package org.example.domain.user.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.user.exception.errorCode.UserErrorCode;

public class RunOutOfMoneyException extends GlobalBusinessException {
    public static final RunOutOfMoneyException EXCEPTION = new RunOutOfMoneyException();

    public RunOutOfMoneyException() { super(UserErrorCode.RUN_OUT_OF_MONEY); }
}
