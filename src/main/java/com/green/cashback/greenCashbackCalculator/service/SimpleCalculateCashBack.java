package com.green.cashback.greenCashbackCalculator.service;


import com.green.cashback.greenCashbackCalculator.model.CalculateStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author gfaraujo
 */
@Component
public final class SimpleCalculateCashBack implements CalculateStrategy {
    
    @Override
    public BigDecimal calculateCashBack(int bottlesQuantity) {
        
        var cashBackValue = new BigDecimal(0.32);
        
        return cashBackValue.multiply(BigDecimal.valueOf(bottlesQuantity));
    }
}
