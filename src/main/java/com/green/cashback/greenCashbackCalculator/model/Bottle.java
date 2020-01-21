package com.green.cashback.greenCashbackCalculator.model;

import javax.validation.constraints.Min;

/**
 * @author gfaraujo
 */
public class Bottle {

    private Bottle() {
    }

    public Bottle(final int quantity) {
        this.quantity = quantity;
    }

    @Min(value = 1, message = "The value must be greater than")
    private int quantity;


    public int getQuantity() {
        return quantity;
    }
}
