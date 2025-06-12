package org.example.domain.friend.dto.response;

import org.example.domain.user.model.User;

import java.util.List;
import java.util.UUID;

public record GetNonFriendUsersResponseDto(
    List<UserInfoDto> users
) {
    public static GetNonFriendUsersResponseDto from(List<User> userList) {
        return new GetNonFriendUsersResponseDto(
                userList.stream().map(UserInfoDto::from).toList()
        );
    }
}

record UserInfoDto(
    String userId,
    String username,
    String profile
) {
    public static UserInfoDto from(User user) {
        return new UserInfoDto(
                user.getUserId(),
                user.getUsername(),
                user.getProfile()
        );
    }
}
