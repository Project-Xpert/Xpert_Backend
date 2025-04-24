package org.example.domain.comment.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.comment.exception.errorCode.CommentErrorCode;

public class IsNotOwnerOfCommentException extends GlobalBusinessException {
    public static final IsNotOwnerOfCommentException EXCEPTION = new IsNotOwnerOfCommentException();

    public IsNotOwnerOfCommentException() { super(CommentErrorCode.IS_NOT_OWNER_OF_COMMENT); }
}
