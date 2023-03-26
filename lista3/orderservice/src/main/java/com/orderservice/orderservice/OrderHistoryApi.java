package com.orderservice.orderservice;

import org.openapitools.client.api.OrderControllerApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderHistoryApi {
    private final OrderControllerApi controllerApi;

    public OrderHistoryApi() {
        System.out.println("init");
        controllerApi = new OrderControllerApi();
    }
    @Bean
    public OrderControllerApi getControllerApi() {
        return controllerApi;
    }
}
