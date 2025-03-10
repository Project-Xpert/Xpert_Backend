package org.example.domain.user.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.user.exception.errorCode.UserErrorCode;

public class EmailAlreadyExistsException extends GlobalBusinessException {
    public static final EmailAlreadyExistsException EXCEPTION = new EmailAlreadyExistsException();

    public EmailAlreadyExistsException() { super(UserErrorCode.EMAIL_ALREADY_EXISTS); }
}
