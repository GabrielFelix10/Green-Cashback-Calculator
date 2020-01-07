package com.green.cashback.greenCashbackCalculator.model.response;

import java.math.BigDecimal;

/**
 * @author gfaraujo
 */
public class CashBackCalculatedDTO {

    private CashBackCalculatedDTO() {

    }

    public CashBackCalculatedDTO(final BigDecimal cashBackValue) {
        this.cashBackValue = cashBackValue;
    }

    public BigDecimal getCashBackValue() {
        return cashBackValue;
    }

    private BigDecimal cashBackValue;


}
