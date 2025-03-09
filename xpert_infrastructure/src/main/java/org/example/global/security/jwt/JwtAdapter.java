package org.example.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.example.common.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtAdapter implements JwtService {
    private final JwtProperties jwtProperties;

    @Override
    public String generateAccess(String userId) {
        Long now = (new Date()).getTime();
        Date expiredAt = new Date(now + jwtProperties.access_time());

        String token = Jwts.builder()
                .setSubject(userId)
                .claim("type", "access")
                .setExpiration(expiredAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .compact();

        return token;
    }
}
