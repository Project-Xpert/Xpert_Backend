package org.example.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record MailSendRequestDto(
        @NotBlank @Length(max = 25) String mail
) {
}
