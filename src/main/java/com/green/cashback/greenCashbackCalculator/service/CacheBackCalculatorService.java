package com.green.cashback.greenCashbackCalculator.service;

import com.green.cashback.greenCashbackCalculator.model.CalculateStrategy;
import com.green.cashback.greenCashbackCalculator.model.response.CashBackCalculatedDTO;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.Optional;

/**
 * @author gfaraujo
 */
@Service
public class CacheBackCalculatorService {

    public Optional<CashBackCalculatedDTO> calculateCachback(
            final CalculateStrategy calculateStrategy,
            final int bottlesQuantity) {

        return Optional.of(new CashBackCalculatedDTO(calculateStrategy.calculateCashBack(bottlesQuantity).setScale(2, RoundingMode.HALF_EVEN)));

    }
}
