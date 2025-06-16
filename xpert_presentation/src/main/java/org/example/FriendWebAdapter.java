package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.friend.dto.request.SendMoneyRequestDto;
import org.example.domain.friend.dto.response.*;
import org.example.domain.friend.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendWebAdapter {
    private final AddFriendUseCase addFriendUseCase;
    private final DeleteFriendUseCase deleteFriendUseCase;
    private final GetAddFriendListItemUseCase getAddFriendListItemUseCase;
    private final GetFriendsRequestersUseCase getFriendsRequestersUseCase;
    private final AcceptFriendUseCase acceptFriendUseCase;
    private final GetFriendListUseCase getFriendListUseCase;
    private final GetFriendDetailUseCase getFriendDetailUseCase;
    private final SendMoneyUseCase sendMoneyUseCase;
    private final GetRankingUseCase getRankingUseCase;

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
    @GetMapping("/new")
    public GetNonFriendUsersResponseDto getFriend(@RequestParam String keyword) {
        return getAddFriendListItemUseCase.execute(keyword);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/request")
    public GetFriendRequestersResponseDto getRequesters() {
        return getFriendsRequestersUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{friendId}")
    public void acceptFriendRequest(@PathVariable String friendId) {
        acceptFriendUseCase.execute(friendId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public GetFriendListResponseDto getFriendList(@RequestParam String keyword) {
        return getFriendListUseCase.execute(keyword);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail/{friendId}")
    public GetFriendDetailResponseDto getFriendDetail(@PathVariable String friendId) {
        return getFriendDetailUseCase.execute(friendId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/money/{friendId}")
    public void sendMoney(@PathVariable String friendId, @Validated @RequestBody SendMoneyRequestDto request) {
        sendMoneyUseCase.execute(friendId, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/ranking")
    public GetFriendRankingResponseDto getRanking() {
        return getRankingUseCase.execute();
    }
}
