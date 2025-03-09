package org.example.global.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        String prefix,
        String header,
        String secret,
        Long access_time,
        Long refresh_time
) {
}
