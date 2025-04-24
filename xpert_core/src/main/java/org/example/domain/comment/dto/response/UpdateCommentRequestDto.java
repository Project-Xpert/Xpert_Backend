package org.example.domain.comment.dto.response;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UpdateCommentRequestDto(
    @NotBlank
    @Length(max = 100)
    String content
) {
}
