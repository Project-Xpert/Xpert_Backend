package org.example.domain.comment.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.comment.exception.errorCode.CommentErrorCode;

public class CommentNotFoundException extends GlobalBusinessException {
    public static final CommentNotFoundException EXCEPTION = new CommentNotFoundException();

    public CommentNotFoundException() { super(CommentErrorCode.COMMENT_NOT_FOUND); }
}
