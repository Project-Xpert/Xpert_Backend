package org.example.global.thirdparty.redis;

import lombok.RequiredArgsConstructor;
import org.example.common.service.RedisService;
import org.example.global.thirdparty.redis.exception.KeyNotExistInRedisException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {
    private final StringRedisTemplate redis;

    @Override
    public void saveData(String key, String value, long duration) {
        ValueOperations<String, String> valueOperations = redis.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key, value, expireDuration);
    }

    @Override
    public String getValueByKey(String key) {
        ValueOperations<String, String> valueOperations = redis.opsForValue();
        String data = valueOperations.get(key);

        if (data == null) {
            throw KeyNotExistInRedisException.EXCEPTION;
        }

        return data;
    }
}
