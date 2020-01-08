package service;

import com.green.cashback.greenCashbackCalculator.service.CacheBackCalculatorService;
import com.green.cashback.greenCashbackCalculator.service.SimpleCalculateCashBack;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author gfaraujo
 */
public class SimpleCalculateCashBackTest {

    private SimpleCalculateCashBack calculateCashBack = new SimpleCalculateCashBack();

    private CacheBackCalculatorService cacheBackCalculatorService = new CacheBackCalculatorService();

    @Test
    public void mustReturnTheCorrectCashBack() {
        var bottlesQuantity = 2;
        var expected = new BigDecimal(0.32).multiply(BigDecimal.valueOf(bottlesQuantity)).setScale(2, RoundingMode.HALF_EVEN);

        var  cashBackValue = cacheBackCalculatorService.calculateCachback(calculateCashBack, 2);

        Assert.assertEquals(cashBackValue.get().getCashBackValue(), expected);
    }
}
