package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.dto.response.GetFriendListResponseDto;
import org.example.domain.friend.service.GetFriendService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetFriendListUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetFriendService getFriendService;

    public GetFriendListResponseDto execute(String keyword) {
        User user = currentUserProvider.getCurrentUser();
        List<User> friendDataList = getFriendService.findAcceptedFriendUsersByUserByKeyword(user, keyword);

        return GetFriendListResponseDto.from(friendDataList);
    }
}
