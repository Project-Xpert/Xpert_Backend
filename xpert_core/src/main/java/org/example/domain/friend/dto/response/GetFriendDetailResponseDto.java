package org.example.domain.friend.dto.response;

import org.example.domain.user.model.User;

public record GetFriendDetailResponseDto(
    String userId,
    String username,
    String profile,
    Long money
) {
    public static GetFriendDetailResponseDto from(User user) {
        return new GetFriendDetailResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getProfile(),
                user.getMoney()
        );
    }
}
