package org.example.domain.friend.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.friend.exception.errorCode.FriendErrorCode;

public class FriendAlreadyExistsException extends GlobalBusinessException {
    public static final FriendAlreadyExistsException EXCEPTION = new FriendAlreadyExistsException();

    public FriendAlreadyExistsException() {
        super(FriendErrorCode.FRIEND_ALREADY_EXISTS);
    }
}
