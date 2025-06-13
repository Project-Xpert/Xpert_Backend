package org.example.domain.friend.dto.response;

import org.example.domain.user.model.User;

import java.util.List;

public record GetFriendListResponseDto(
    List<FriendListItem> friends
) {
    public static GetFriendListResponseDto from(List<User> friendDataList) {
        return new GetFriendListResponseDto(
                friendDataList.stream().map(FriendListItem::from).toList()
        );
    }
}

record FriendListItem(
    String profile,
    String userId,
    String username
) {
    public static FriendListItem from(User user) {
        return new FriendListItem(
            user.getProfile(),
            user.getUserId(),
            user.getUsername()
        );
    }
}
