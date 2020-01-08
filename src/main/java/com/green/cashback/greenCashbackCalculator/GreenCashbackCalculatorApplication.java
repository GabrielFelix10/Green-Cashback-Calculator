package com.green.cashback.greenCashbackCalculator;

import com.green.cashback.greenCashbackCalculator.config.swagger.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import( SwaggerConfig.class)
public class GreenCashbackCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenCashbackCalculatorApplication.class, args);
	}

}
