package org.example.domain.friend.dto.response;

import org.example.domain.friend.spi.vo.AddFriendListItemVO;
import org.example.domain.user.model.User;

import java.util.List;
import java.util.UUID;

public record GetNonFriendUsersResponseDto(
    List<AddFriendListItemVO> users
) {
    public static GetNonFriendUsersResponseDto from(List<AddFriendListItemVO> userList) {
        return new GetNonFriendUsersResponseDto(userList);
    }
}
