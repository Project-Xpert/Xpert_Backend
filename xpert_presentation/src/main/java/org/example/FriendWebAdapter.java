package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.dto.response.GetNonFriendUsersResponseDto;
import org.example.domain.friend.usecase.AddFriendUseCase;
import org.example.domain.friend.usecase.DeleteFriendUseCase;
import org.example.domain.friend.usecase.GetNonFriendUsersUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendWebAdapter {
    private final AddFriendUseCase addFriendUseCase;
    private final DeleteFriendUseCase deleteFriendUseCase;
    private final GetNonFriendUsersUseCase getNonFriendUsersUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{friendId}")
    public void addFriend(@PathVariable String friendId) {
        addFriendUseCase.execute(friendId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{friendId}")
    public void deleteFriend(@PathVariable String friendId) {
        deleteFriendUseCase.execute(friendId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/new-friend")
    public GetNonFriendUsersResponseDto getFriend(@RequestParam String keyword) {
        return getNonFriendUsersUseCase.execute(keyword);
    }
}
