package org.example.common.service;

public interface SecurityService {

    String encryptPassword(String rawPassword);

    void checkPasswordMatches(String rawPassword, String encryptedPassword);
}
