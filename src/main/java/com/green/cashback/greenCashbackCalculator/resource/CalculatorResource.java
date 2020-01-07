package com.green.cashback.greenCashbackCalculator.resource;

import com.green.cashback.greenCashbackCalculator.model.Bottle;
import com.green.cashback.greenCashbackCalculator.service.SimpleCalculateCashBack;
import com.green.cashback.greenCashbackCalculator.model.response.CashBackCalculatedDTO;
import com.green.cashback.greenCashbackCalculator.service.CacheBackCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author gfaraujo
 */
@RestController
public class CalculatorResource {

    @Autowired
    private CacheBackCalculatorService service;

    @Autowired
    private SimpleCalculateCashBack simpleCalculateCashBack;

    @PostMapping("/cash-back")
    public ResponseEntity<CashBackCalculatedDTO> calculateCashBack(@Valid @RequestBody final Bottle bottle){

       return service.calculateCachback(simpleCalculateCashBack, bottle.getQuantity())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
