package org.example.domain.friend.dto.request;

import jakarta.validation.constraints.NotNull;

public record SendMoneyRequestDto(
    @NotNull
    Long money
) {
}
