package org.example.domain.comment.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum CommentErrorCode implements GlobalErrorCode {
    IS_NOT_OWNER_OF_COMMENT(403, "댓글의 작성자가 아닙니다."),
    COMMENT_NOT_FOUND(404, "댓글이 존재하지 않습니다.");

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
