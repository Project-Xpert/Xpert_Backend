package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.user.dto.request.SignupRequestDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.CheckUserService;
import org.example.domain.user.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupUseCase {
    private final CheckUserService checkUserService;
    private final CommandUserService commandUserService;
    private final SecurityService securityService;

    public void execute(SignupRequestDto request) {
        checkUserService.checkUserAlreadyExistsByUserId(request.userId());
        checkUserService.checkUserAlreadyExistsByEmail(request.email());

        String encryptedPassword = securityService.encryptPassword(request.password());

        commandUserService.saveUser(User.builder()
                .userId(request.userId())
                .email(request.email())
                .password(encryptedPassword)
                .username(request.username())
                .profile(request.profile())
                .build()
        );
    }
}
