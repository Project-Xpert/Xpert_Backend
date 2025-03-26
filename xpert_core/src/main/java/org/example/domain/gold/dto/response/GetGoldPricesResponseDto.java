package org.example.domain.gold.dto.response;

import lombok.Builder;
import org.example.common.openAPI.gold.vo.GoldItemVO;

import java.util.List;

@Builder
public record GetGoldPricesResponseDto(
        List<GoldItemVO> goldPrices
) {
}
