package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

interface OrderRepository extends CrudRepository<Order, Long> {}

@Service
public class OrderService implements CustomService<Order> {
    @Autowired
    OrderRepository repository;

    public List<Order> getAll() {
        List<Order> elems = new ArrayList<>();
        repository.findAll().forEach(elems::add);
        return elems;
    }

    public Order getById(long id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Order elem) {
        repository.save(elem);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}