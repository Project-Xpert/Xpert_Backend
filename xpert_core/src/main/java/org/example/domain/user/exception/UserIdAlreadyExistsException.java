package org.example.domain.user.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.user.exception.errorCode.UserErrorCode;

public class UserIdAlreadyExistsException extends GlobalBusinessException {
    public static final UserIdAlreadyExistsException EXCEPTION = new UserIdAlreadyExistsException();

    public UserIdAlreadyExistsException() { super(UserErrorCode.USER_ID_ALREADY_EXISTS); }

}
