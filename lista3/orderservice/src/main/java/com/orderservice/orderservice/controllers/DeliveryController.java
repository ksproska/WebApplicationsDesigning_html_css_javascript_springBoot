package com.orderservice.orderservice.controllers;

import com.orderservice.orderservice.models.Delivery;
import com.orderservice.orderservice.models.Order;
import com.orderservice.orderservice.services.DeliveryService;
import com.orderservice.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/deliveries")
@RestController
public class DeliveryController {
    @Autowired
    DeliveryService service;

    @GetMapping()
    private List<Delivery> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    private Delivery get(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping()
    private long save(@RequestBody Delivery elem) {
        service.saveOrUpdate(elem);
        return elem.getId();
    }
}
