package org.example.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record VerifyCodeRequestDto(
        @NotBlank @Length(max = 25) String mail,
        @NotBlank @Length(max = 4, min = 4) String code
) {
}
