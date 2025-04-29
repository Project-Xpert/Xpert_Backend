package org.example.domain.reply.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum ReplyErrorCode implements GlobalErrorCode {
    IS_NOT_OWNER_OF_REPLY(403, "해당 대댓글의 작성자가 아닙니다"),
    REPLY_NOT_FOUND(404, "대댓글을 찾을 수 없습니다");

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
