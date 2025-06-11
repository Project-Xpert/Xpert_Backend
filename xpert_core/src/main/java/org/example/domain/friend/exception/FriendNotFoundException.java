package org.example.domain.friend.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.friend.exception.errorCode.FriendErrorCode;

public class FriendNotFoundException extends GlobalBusinessException {
    public static final FriendNotFoundException EXCEPTION = new FriendNotFoundException();

    public FriendNotFoundException() {
        super(FriendErrorCode.FRIEND_NOT_FOUND);
    }
}
