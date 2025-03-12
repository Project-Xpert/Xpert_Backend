package org.example.domain.user.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.user.exception.errorCode.UserErrorCode;

public class CodeNotMatchesException extends GlobalBusinessException {
    public static final CodeNotMatchesException EXCEPTION = new CodeNotMatchesException();

    public CodeNotMatchesException() { super(UserErrorCode.CODE_NOT_MATCHES); }
}
