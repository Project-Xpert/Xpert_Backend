package org.example.domain.friend.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum FriendErrorCode implements GlobalErrorCode {
    FRIEND_NOT_FOUND(404, "친구 정보를 찾을 수 없습니다."),
    FRIEND_ALREADY_EXISTS(409, "이미 해당 친구 관계가 존재합니다."),
    FRIEND_WITH_SELF_NOT_ALLOWED(409, "자기 자신과 친구를 맺을 수 없습니다.");

    private final int errorCode;
    private final String errorMessage;

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
