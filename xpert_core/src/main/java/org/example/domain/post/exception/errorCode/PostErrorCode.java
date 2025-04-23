package org.example.domain.post.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum PostErrorCode implements GlobalErrorCode {
    IS_NOT_OWNER(403, "게시물의 작성자가 아닙니다"),
    POST_NOT_FOUND(404, "게시글을 찾을 수 없습니다");

    private final int errorCode;
    private final String errorMessage;

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
