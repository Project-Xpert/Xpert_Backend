package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.dto.request.*;
import org.example.domain.user.dto.response.LoginResponseDto;
import org.example.domain.user.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserWebAdapter {
    private final SignupUseCase signupUseCase;
    private final LoginUseCase loginUseCase;
    private final MailSendUseCase mailSendUseCase;
    private final VerifyCodeUseCase verifyCodeUseCase;
    private final CheckUniqueAttributeUseCase checkUniqueAttributeUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(
            @RequestPart(value = "file", required = false) MultipartFile file,
            @Validated @RequestPart(value = "body") SignupRequestDto request
    ) {
        signupUseCase.execute(request, file);
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

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/mail/code")
    public void sendMail(@Validated @RequestBody MailSendRequestDto request) {
        mailSendUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/verify/code")
    public void verifyCode(@Validated @RequestBody VerifyCodeRequestDto request) {
        verifyCodeUseCase.execute(request);
    }
}
