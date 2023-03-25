package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService implements CustomService<OrderItem> {
    @Autowired
    OrderItemRepository repository;


    public List<OrderItem> getAll() {
        List<OrderItem> elems = new ArrayList<>();
        repository.findAll().forEach(elems::add);
        return elems;
    }

    public OrderItem getById(long id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(OrderItem elem) {
        repository.save(elem);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}