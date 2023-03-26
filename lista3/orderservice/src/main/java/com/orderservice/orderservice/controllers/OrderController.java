package com.orderservice.orderservice.controllers;

//import com.orderservice.model.OrderHistory;
//import com.orderservice.orderservice.OrderhistoryApiImpl;
import com.orderservice.orderservice.models.Order;
import com.orderservice.orderservice.models.OrderItem;
import com.orderservice.orderservice.models.Product;
import com.orderservice.orderservice.services.OrderService;
import org.openapitools.client.api.OrderControllerApi;
import org.openapitools.client.model.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/orders")
@RestController
public class OrderController {
    @Autowired
    OrderService service;

    @Autowired
    OrderControllerApi controllerApi;

    @GetMapping()
    private List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    private Order get(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping()
    private long save(@RequestBody Order elem) {
        service.saveOrUpdate(elem);

        var history = new OrderHistory();
        history.setConsumerName(elem.getConsumerName());
        var products = elem.getOrderItems().stream().map(OrderItem::getProduct).map(Product::getName).collect(Collectors.joining(","));
        var totalPrice = elem.getOrderItems().stream().map(OrderItem::getProduct).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        history.setProductNames(products);
        history.setTotalPrice(totalPrice);
        history.setConsumerName(elem.getConsumerName());

        controllerApi.save(history);

        return elem.getId();
    }
}
