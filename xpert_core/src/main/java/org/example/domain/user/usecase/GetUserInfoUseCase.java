package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.domain.user.dto.response.GetUserInfoResponseDto;
import org.example.domain.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetUserInfoUseCase {
    private final CurrentUserProvider currentUserProvider;

    public GetUserInfoResponseDto execute() {
        User user = currentUserProvider.getCurrentUser();

        return new GetUserInfoResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getProfile(),
                Math.toIntExact(user.getMoney())
        );
    }
}
