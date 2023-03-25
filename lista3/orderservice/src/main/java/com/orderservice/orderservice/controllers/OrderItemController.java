package com.orderservice.orderservice.controllers;

import com.orderservice.orderservice.models.OrderItem;
import com.orderservice.orderservice.resources.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/items")
@RestController
public class OrderItemController {
    @Autowired
    OrderItemService service;

    @GetMapping()
    private List<OrderItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    private OrderItem get(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping()
    private long save(@RequestBody OrderItem elem) {
        service.saveOrUpdate(elem);
        return elem.getId();
    }
}
