package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.dto.request.SignupRequestDto;
import org.example.domain.user.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserWebAdapter {
    private final SignupUseCase signupUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@Validated @RequestBody SignupRequestDto request) {
        signupUseCase.execute(request);
    }
}
