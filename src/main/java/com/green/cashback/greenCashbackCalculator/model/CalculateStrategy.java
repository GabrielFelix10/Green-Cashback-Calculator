package com.green.cashback.greenCashbackCalculator.model;

import java.math.BigDecimal;

/**
 * @author gfaraujo
 */
public interface CalculateStrategy {

   BigDecimal calculateCashBack(final int bottlesQuantity);
}
