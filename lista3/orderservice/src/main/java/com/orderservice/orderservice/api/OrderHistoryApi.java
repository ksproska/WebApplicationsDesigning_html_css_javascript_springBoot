package com.orderservice.orderservice.api;

import com.orderservice.orderservice.models.*;
import org.openapitools.client.api.OrderControllerApi;
import org.openapitools.client.model.OrderHistory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Configuration
public class OrderHistoryApi {
    private final OrderControllerApi controllerApi;

    public OrderHistoryApi() {
        controllerApi = new OrderControllerApi();
    }
    @Bean
    public OrderControllerApi getControllerApi() {
        return controllerApi;
    }

    public Long save(Order elem) {
        var history = new OrderHistory();
        history.setConsumerName(elem.getConsumerName());
        var products = elem.getOrderItems().stream().map(OrderItem::getProduct).map(Product::getName).collect(Collectors.joining(","));
        var totalPrice = elem.getOrderItems().stream().map(OrderItem::getProduct).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        history.setProductNames(products);
        history.setTotalPrice(totalPrice);
        history.setCourierName(elem.getDelivery().getCourierName());
        return controllerApi.save(history);
    }

    public void update(Delivery delivery) {}
}
