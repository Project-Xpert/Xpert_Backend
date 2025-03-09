package org.example.global.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.global.security.auth.CustomUserDetails;
import org.example.global.security.auth.CustomUserDetailsService;
import org.example.global.security.exception.InvalidTokenException;
import org.example.global.security.exception.TokenExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@RequiredArgsConstructor
public class JwtParser {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    public Authentication getAuthentication(String token) {
        Claims claims = this.getClaims(token);

        if (!claims.get("type").equals("access")) {
            throw InvalidTokenException.EXCEPTION;
        }

        CustomUserDetails userDetails = customUserDetailsService.getUserDetailsByUserId(claims.getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails.userId(), "", userDetails.getAuthorities());
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.secret())
                    .parseClaimsJwt(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw TokenExpiredException.EXCEPTION;
         }catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public String getHeader(HttpServletRequest request) {
        String token = request.getHeader(jwtProperties.header());

        if (token != null && !token.isBlank() && token.length() > 7
                && token.startsWith(jwtProperties.prefix()) && !token.split(" ")[1].isEmpty()) {
            token = token.split(" ")[1];
        }

        return token;
    }
}
