package org.example.global.security.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class PasswordMismatchException extends GlobalBusinessException {
    public static final PasswordMismatchException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() { super(SecurityErrorCode.PASSWORD_MISMATCHES); }
}
