package org.example.global.security.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class InvalidTokenException extends GlobalBusinessException {
    public static final InvalidTokenException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() { super(SecurityErrorCode.INVALID_TOKEN); }
}
