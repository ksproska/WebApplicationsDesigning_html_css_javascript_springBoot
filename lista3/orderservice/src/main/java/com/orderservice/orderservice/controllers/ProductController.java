package com.orderservice.orderservice.controllers;

import com.orderservice.orderservice.models.Product;
import com.orderservice.orderservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping()
    private List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    private Product get(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping()
    private long save(@RequestBody Product elem) {
        service.saveOrUpdate(elem);
        return elem.getId();
    }
}
