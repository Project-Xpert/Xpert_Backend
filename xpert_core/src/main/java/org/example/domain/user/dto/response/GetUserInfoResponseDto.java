package org.example.domain.user.dto.response;

public record GetUserInfoResponseDto(
    String userId,
    String username,
    String profile,
    int money
) {
}
