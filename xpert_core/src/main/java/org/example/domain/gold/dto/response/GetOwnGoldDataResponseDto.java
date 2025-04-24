package org.example.domain.gold.dto.response;

import org.example.domain.gold.model.Gold;

import java.util.List;

public record GetOwnGoldDataResponseDto(
    Long userMoney,
    List<GoldDatum> ownGolds
) {
    public static GetOwnGoldDataResponseDto of(Long userMoney, List<Gold> golds) {
        return new GetOwnGoldDataResponseDto(
                userMoney,
                golds.stream().map(GoldDatum::from).toList()
        );
    }
}

record GoldDatum(
   String goldType,
   int cnt
) {
    static GoldDatum from(Gold gold) {
        return new GoldDatum(
                gold.getGoldType().name().substring(2),
                gold.getCnt()
        );
    }
}
