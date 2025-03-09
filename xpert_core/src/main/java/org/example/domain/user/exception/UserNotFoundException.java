package org.example.domain.user.exception;

import org.example.common.exception.GlobalBusinessException;

public class UserNotFoundException extends GlobalBusinessException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() { super(UserErrorCode.USER_NOT_FOUND); }
}
