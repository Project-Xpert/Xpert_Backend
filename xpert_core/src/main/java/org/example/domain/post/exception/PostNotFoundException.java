package org.example.domain.post.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.post.exception.errorCode.PostErrorCode;

public class PostNotFoundException extends GlobalBusinessException {
    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    public PostNotFoundException() { super(PostErrorCode.POST_NOT_FOUND); }
}
