package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.spi.QueryStockPort;
import org.example.domain.stock.spi.vo.StockCodeListVO;
import org.example.stock.mapper.StockMapper;
import org.example.stock.repository.StockJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockPersistenceAdapter implements QueryStockPort {
    private final StockJpaRepository stockJpaRepository;
    private final StockMapper stockMapper;

    @Override
    public List<Stock> getStocks() {
        return stockJpaRepository.findAllStocks().stream()
                .map((entity) -> stockMapper.toDomain(Optional.of(entity)).get())
                .toList();
    }
}
