package org.example.global.thirdparty.redis.exception;

import org.example.common.exception.GlobalBusinessException;

public class KeyNotExistInRedisException extends GlobalBusinessException {
    public static final KeyNotExistInRedisException EXCEPTION = new KeyNotExistInRedisException();

    public KeyNotExistInRedisException() { super(RedisErrorCode.KEY_NOT_EXIST_IN_REDIS); };
}