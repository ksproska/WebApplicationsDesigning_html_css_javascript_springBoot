package com.orderhistory.orderhistory.services;

import com.orderhistory.orderhistory.models.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<OrderHistory> getAll() {
        List<OrderHistory> elems = new ArrayList<>();
        repository.findAll().forEach(elems::add);
        return elems;
    }

    public List<OrderHistory> getAllForConsumer(String consumerName) {
        return repository.findAllForConsumerName(consumerName);
    }

    public Page<OrderHistory> getAllForConsumerPagination(String consumerName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllForConsumerName(consumerName, pageable);
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