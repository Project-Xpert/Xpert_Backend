package org.example.domain.post.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.post.exception.errorCode.PostErrorCode;

public class IsNotOwnerOfPostException extends GlobalBusinessException {
    public static final IsNotOwnerOfPostException EXCEPTION = new IsNotOwnerOfPostException();

    public IsNotOwnerOfPostException() { super(PostErrorCode.IS_NOT_OWNER); }
}
