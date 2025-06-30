package org.example.domain.stock.dto.response;

import org.example.domain.stock.spi.vo.StockListItemVO;

import java.util.List;

public record GetOwnStockListResponseDto(
    List<StockListItemVO> stocks
) {
}
