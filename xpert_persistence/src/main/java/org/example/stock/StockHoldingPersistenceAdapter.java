package org.example.stock;

import lombok.RequiredArgsConstructor;
import org.example.domain.stock.dto.vo.StockOrderByEnum;
import org.example.domain.stock.modal.StockHolding;
import org.example.domain.stock.spi.QueryStockHoldingPort;
import org.example.domain.stock.spi.vo.StockListItemVO;
import org.example.stock.entity.StockHoldingId;
import org.example.stock.entity.StockJpaEntity;
import org.example.stock.mapper.StockHoldingMapper;
import org.example.stock.repository.StockHoldingJpaRepository;
import org.example.stock.repository.StockJpaRepository;
import org.example.user.entity.UserJpaEntity;
import org.example.user.repository.UserJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockHoldingPersistenceAdapter implements QueryStockHoldingPort {
    private final StockHoldingJpaRepository stockHoldingJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final StockJpaRepository stockJpaRepository;
    private final StockHoldingMapper stockHoldingMapper;

    @Override
    public boolean existsByUserIdAndStockCode(String userId, String stockCode) {
        UserJpaEntity userEntity = userJpaRepository.findById(userId).get();
        StockJpaEntity stockEntity = stockJpaRepository.findById(stockCode).get();

        return stockHoldingJpaRepository.existsById(new StockHoldingId(userEntity, stockEntity));
    }

    @Override
    public void save(StockHolding stockHolding) {
        stockHoldingJpaRepository.save(
                stockHoldingMapper.toEntity(stockHolding)
        );
    }

    @Override
    public Optional<StockHolding> getStockHoldingByUserIdAndStockCode(String userId, String stockCode) {
        UserJpaEntity userEntity = userJpaRepository.findById(userId).get();
        StockJpaEntity stockEntity = stockJpaRepository.findById(stockCode).get();

        return stockHoldingMapper.toDomain(
                stockHoldingJpaRepository.findById(
                        new StockHoldingId(userEntity, stockEntity)
                )
        );
    }

    @Override
    public void delete(StockHolding stockHolding) {
        stockHoldingJpaRepository.delete(stockHoldingMapper.toEntity(stockHolding));
    }

    @Override
    public List<StockListItemVO> getOwnedStockListByUserId(String userId, String keyword, StockOrderByEnum criteria) {
        if (criteria == StockOrderByEnum.RATE_ABS_DESC) {
            return stockHoldingJpaRepository.getOwnedStockListByUserIdOrderByFluRateAbs(userId, keyword);
        } else {
            Sort sort = switch (criteria) {
                case PRICE_DESC -> Sort.by(Sort.Direction.DESC, "sp.price");
                case PRICE_ASC -> Sort.by(Sort.Direction.ASC, "sp.price");
                case RATE_DESC -> Sort.by(Sort.Direction.DESC, "sp.percentChange");
                case RATE_ASC -> Sort.by(Sort.Direction.ASC, "sp.percentChange");
                default ->  Sort.by(Sort.Direction.DESC, "p.stockCode");
            };

            Pageable pageable = PageRequest.of(0, 60, sort);

            return stockHoldingJpaRepository.getOwnedStockListByUserId(userId, keyword, pageable);
        }
    }
}
