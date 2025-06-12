package org.example.domain.friend.spi.vo;

public record AddFriendListItemVO(
    String userId,
    String username,
    String profile,
    boolean hadRequested
) {
}
