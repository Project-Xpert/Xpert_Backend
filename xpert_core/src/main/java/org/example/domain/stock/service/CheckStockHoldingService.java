package org.example.domain.stock.service;

public interface CheckStockHoldingService {

    boolean getExistsByUserIdAndStockCode(String userId, String stockCode);
}
