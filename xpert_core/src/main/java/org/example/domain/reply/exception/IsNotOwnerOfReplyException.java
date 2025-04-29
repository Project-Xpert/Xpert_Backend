package org.example.domain.reply.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.reply.exception.errorCode.ReplyErrorCode;

public class IsNotOwnerOfReplyException extends GlobalBusinessException {
    public static final IsNotOwnerOfReplyException EXCEPTION = new IsNotOwnerOfReplyException();

    public IsNotOwnerOfReplyException() { super(ReplyErrorCode.IS_NOT_OWNER_OF_REPLY); }
}
