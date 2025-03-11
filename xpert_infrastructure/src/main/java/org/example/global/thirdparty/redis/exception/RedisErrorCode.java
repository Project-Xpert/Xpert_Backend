package org.example.global.thirdparty.redis.exception;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum RedisErrorCode implements GlobalErrorCode {
    KEY_NOT_EXIST_IN_REDIS(404, "해당 키가 Redis안에 존재하지 않습니다.");

    private final int errorCode;
    private final String errorMessage;

    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
