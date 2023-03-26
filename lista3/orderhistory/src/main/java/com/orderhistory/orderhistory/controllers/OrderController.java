package com.orderhistory.orderhistory.controllers;

import com.orderhistory.orderhistory.models.OrderHistory;
import com.orderhistory.orderhistory.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ordershistory")
@RestController
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping()
    private List<OrderHistory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    private OrderHistory get(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping()
    private long save(@RequestBody OrderHistory elem) {
        service.saveOrUpdate(elem);
        return elem.getId();
    }
}
