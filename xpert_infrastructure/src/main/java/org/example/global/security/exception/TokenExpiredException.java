package org.example.global.security.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class TokenExpiredException extends GlobalBusinessException {
    public static final TokenExpiredException EXCEPTION = new TokenExpiredException();

    public TokenExpiredException() { super(SecurityErrorCode.TOKEN_EXPIRED); }
}
