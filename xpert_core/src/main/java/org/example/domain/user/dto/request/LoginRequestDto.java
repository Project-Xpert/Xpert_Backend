package org.example.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record LoginRequestDto(
        @NotBlank @Length(max = 20, min = 3) String userId,
        @NotBlank String password
) {
}
