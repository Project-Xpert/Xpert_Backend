package org.example.domain.gold.model;

import lombok.Builder;

@Builder
public record Gold (
        GoldType goldType,
        String userId,
        int cnt
) {
}
