package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.modal.Stock;
import org.example.domain.stock.spi.QueryStockPort;
import org.example.domain.stock.spi.vo.StockListItemVO;
import org.example.stock.mapper.StockMapper;
import org.example.stock.repository.StockJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<StockListItemVO> searchStockByKeywordAndOrder(String keyword, StockOrderByEnum criteria) {
        if (criteria == StockOrderByEnum.RATE_ABS_DESC) {
            return stockJpaRepository.searchStocksByKeywordAndOrderByAbsChangePercent(keyword);
        } else {
            Sort sort = switch (criteria) {
                case PRICE_DESC -> Sort.by(Sort.Direction.DESC, "sp.price");
                case PRICE_ASC -> Sort.by(Sort.Direction.ASC, "sp.price");
                case RATE_DESC -> Sort.by(Sort.Direction.DESC, "sp.percentChange");
                case RATE_ASC -> Sort.by(Sort.Direction.ASC, "sp.percentChange");
                default ->  Sort.by(Sort.Direction.DESC, "p.stockCode");
            };

            Pageable pageable = PageRequest.of(0, 60, sort);

            return stockJpaRepository.searchStocksByKeywordAndOrder(keyword, pageable);
        }
    }

    @Override
    public Optional<Stock> getStockById(String stockCode) {
        return stockMapper.toDomain(stockJpaRepository.findById(stockCode));
    }
}
