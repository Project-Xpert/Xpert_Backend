package org.example.domain.friend.dto.response;

import org.example.domain.user.model.User;

import java.util.List;

public record GetFriendRankingResponseDto(
    List<FriendRankingItem> friends
) {
public static GetFriendRankingResponseDto from(List<User> friendDataList) {
    return new GetFriendRankingResponseDto(
            friendDataList.stream().map(FriendRankingItem::from).toList()
    );
}
}

record FriendRankingItem(
        String profile,
        String userId,
        String username,
        Long money
) {
    public static FriendRankingItem from(User user) {
        return new FriendRankingItem(
                user.getProfile(),
                user.getUserId(),
                user.getUsername(),
                user.getMoney()
        );
    }
}
