package org.example.domain.friend.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.friend.dto.response.GetFriendRequestersResponseDto;
import org.example.domain.friend.service.GetFriendService;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetFriendsRequestersUseCase {
    private final CurrentUserProvider currentUserProvider;
    private final GetFriendService getFriendService;

    public GetFriendRequestersResponseDto execute() {
        User user = currentUserProvider.getCurrentUser();
        List<User> requesterList = getFriendService.getRequestersByReceiver(user);

        return GetFriendRequestersResponseDto.from(requesterList);
    }
}
