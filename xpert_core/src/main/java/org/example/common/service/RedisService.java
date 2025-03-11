package org.example.common.service;

public interface RedisService {

    void saveData(String key, String value, long duration);

    String getValueByKey(String key);
}
