package com.orderhistory.orderhistory.services;

import com.orderhistory.orderhistory.models.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

interface OrderRepository extends CrudRepository<OrderHistory, Long> {}

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<OrderHistory> getAll() {
        List<OrderHistory> elems = new ArrayList<>();
        repository.findAll().forEach(elems::add);
        return elems;
    }

    public OrderHistory getById(long id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(OrderHistory elem) {
        repository.save(elem);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}