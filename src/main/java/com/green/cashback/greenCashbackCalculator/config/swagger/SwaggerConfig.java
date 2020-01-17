package com.green.cashback.greenCashbackCalculator.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gfaraujo
 */
@EnableSwagger2
public class SwaggerConfig {

    // SWAGGER
    @Bean
    public Docket swaggerConfiguration () {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // remove o mapeamento dos endpoints do SpringBoot
                .apis(RequestHandlerSelectors.basePackage("com.green.cashback.greenCashbackCalculator.resource"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, getDefaultResponseMessages())
                .apiInfo(getApiInfo());
    }

    /**
     * As mensagens para os HTTP status codes
     * default de todos os endpoints da aplicação para {@link RequestMethod#GET}.
     */
    private List<ResponseMessage> getDefaultResponseMessages () {
        final List<ResponseMessage> responseMessages = new ArrayList<>();

        responseMessages.add(new ResponseMessageBuilder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("No value Found")
                .build());

        responseMessages.add(new ResponseMessageBuilder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Wrong request")
                .build());

        responseMessages.add(new ResponseMessageBuilder()
                .code(HttpStatus.BAD_GATEWAY.value())
                .message("Dependencies with error")
                .build());

        responseMessages.add(new ResponseMessageBuilder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Internal Error")
                .build());

        return responseMessages;
    }

    private ApiInfo getApiInfo () {

        return new ApiInfoBuilder()
                .title("Green Cashback Calculator")
                .description("Api that returns a cashback according to the amount of plastic bottles")
                .contact(new Contact("Gabriel Felix", "", "gafelix10@gmail.com"))
                .build();
    }
}
