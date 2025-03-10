package org.example.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record SignupRequestDto(
        @NotBlank @Length(max = 20, min = 3) String userId,
        @NotBlank @Length(max = 25) String email,
        @NotBlank @Length(max = 15, min = 3)  String username,
        @NotBlank String password,
        String profile
) {
}
