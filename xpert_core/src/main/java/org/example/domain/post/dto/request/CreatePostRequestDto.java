package org.example.domain.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreatePostRequestDto (
        @NotBlank
        @Length(max = 40)
        String title,

        @NotBlank
        @Length(max = 300)
        String content
) {
}