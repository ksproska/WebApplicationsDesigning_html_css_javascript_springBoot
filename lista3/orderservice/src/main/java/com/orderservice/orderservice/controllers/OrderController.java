package com.orderservice.orderservice.controllers;

//import com.orderservice.model.OrderHistory;
//import com.orderservice.orderservice.OrderhistoryApiImpl;
import com.orderservice.orderservice.api.OrderHistoryApi;
import com.orderservice.orderservice.models.Order;
import com.orderservice.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {
    @Autowired
    OrderService service;

    @Autowired
    OrderHistoryApi controllerApi;

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
        controllerApi.save(elem);
        service.saveOrUpdate(elem);
        return elem.getId();
    }
}
