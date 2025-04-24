package org.example.domain.reply.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateReplyRequestDto(
    @NotBlank
    @Length(max = 100)
    String content
) {
}
