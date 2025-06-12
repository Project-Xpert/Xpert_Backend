package org.example.domain.friend.dto.response;

import org.example.domain.user.model.User;

import java.util.List;

public record GetFriendRequestersResponseDto(
    List<RequestersListItemDto> friends
) {
    public static GetFriendRequestersResponseDto from(List<User> users) {
        return new GetFriendRequestersResponseDto(
                users.stream().map(RequestersListItemDto::from).toList()
        );
    }
}

record RequestersListItemDto(
    String userId,
    String profile,
    String username
) {
    public static RequestersListItemDto from(User user) {
        return new RequestersListItemDto(
                user.getUserId(),
                user.getProfile(),
                user.getUsername()
        );
    }
}