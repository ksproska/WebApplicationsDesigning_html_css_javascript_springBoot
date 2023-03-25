package com.orderservice.orderservice;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Order Rest Controller", description = "REST API for Order")
@RequestMapping("/orders")
@RestController
public class OrderController {
    private List<Order> orders = new ArrayList<>(){
        {
            add(new Order(0L, "Kamila Sproska", new ArrayList<>() {}, new Delivery(0L, "Pracuś", DeliveryStatus.delivered)));
        }
    };
    @GetMapping("/")
    List<Order> all() {
        return orders;
    }

    @PostMapping("/")
    Order newOrder(@RequestBody Order newOrder) {
        System.out.println(newOrder);
        orders.add(newOrder);
        return newOrder;
    }

    // Single item

    @GetMapping("/{id}")
    Order getById(@PathVariable Long id) {
        return orders.stream().filter(o -> id.equals(o.getId())).findAny().orElse(null);
    }
}
