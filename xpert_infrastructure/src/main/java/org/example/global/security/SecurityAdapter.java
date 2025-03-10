package org.example.global.security;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SecurityAdapter implements SecurityService {
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
