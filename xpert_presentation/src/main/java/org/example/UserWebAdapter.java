package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.dto.request.LoginRequestDto;
import org.example.domain.user.dto.request.SignupRequestDto;
import org.example.domain.user.dto.request.CheckUniqueAttributeRequestDto;
import org.example.domain.user.dto.response.LoginResponseDto;
import org.example.domain.user.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserWebAdapter {
    private final SignupUseCase signupUseCase;
    private final LoginUseCase loginUseCase;
    private final CheckUniqueAttributeUseCase checkUniqueAttributeUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@Validated @RequestBody SignupRequestDto request) {
        signupUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public LoginResponseDto login(@Validated @RequestBody LoginRequestDto request) {
        return loginUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/attribute")
    public void checkUnique(@Validated @RequestBody CheckUniqueAttributeRequestDto request) {
        checkUniqueAttributeUseCase.execute(request);
    }
}
