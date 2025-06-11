package org.example.domain.friend.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.friend.exception.errorCode.FriendErrorCode;

public class FriendWithSelfNotAllowedException extends GlobalBusinessException {
    public static final FriendWithSelfNotAllowedException EXCEPTION = new FriendWithSelfNotAllowedException();

    public FriendWithSelfNotAllowedException() {
        super(FriendErrorCode.FRIEND_WITH_SELF_NOT_ALLOWED);
    }
}
