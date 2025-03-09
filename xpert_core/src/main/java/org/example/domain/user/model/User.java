package org.example.domain.user.model;

import lombok.Builder;

@Builder
public record User(
        String userId,
        String email,
        String username,
        String password,
        String profile,
        Long money
) {
}
