package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService implements CustomService<Delivery> {
    @Autowired
    DeliveryRepository repository;

    public List<Delivery> getAll() {
        List<Delivery> elems = new ArrayList<>();
        repository.findAll().forEach(elems::add);
        return elems;
    }

    public Delivery getById(long id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Delivery elem) {
        repository.save(elem);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}