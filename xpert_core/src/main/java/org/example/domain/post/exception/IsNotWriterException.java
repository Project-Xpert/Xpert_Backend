package org.example.domain.post.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.post.exception.errorCode.PostErrorCode;

public class IsNotWriterException extends GlobalBusinessException {
    public static final IsNotWriterException EXCEPTION = new IsNotWriterException();

    public IsNotWriterException() { super(PostErrorCode.IS_NOT_WRITER); }
}
