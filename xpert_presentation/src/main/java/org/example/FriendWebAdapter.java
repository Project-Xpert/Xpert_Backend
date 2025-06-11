package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.usecase.AddFriendUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendWebAdapter {
    private final AddFriendUseCase addFriendUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{friendId}")
    public void addFriend(@PathVariable String friendId) {
        addFriendUseCase.execute(friendId);
    }
}
