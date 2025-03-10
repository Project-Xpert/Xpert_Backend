package org.example.domain.user.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.JwtService;
import org.example.common.service.SecurityService;
import org.example.domain.user.dto.request.LoginRequestDto;
import org.example.domain.user.dto.response.LoginResponseDto;
import org.example.domain.user.model.User;
import org.example.domain.user.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginUseCase {
    private final GetUserService getUserService;
    private final SecurityService securityService;
    private final JwtService jwtService;

    public LoginResponseDto execute(LoginRequestDto request) {
        User user = getUserService.getUserByUserId(request.userId());

        securityService.checkPasswordMatches(request.password(), user.password());

        return new LoginResponseDto(jwtService.generateAccess(user.userId()));
    }
}
