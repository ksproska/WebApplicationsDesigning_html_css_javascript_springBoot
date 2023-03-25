package com.orderservice.orderservice.resources;

import com.orderservice.orderservice.models.Order;
import com.orderservice.orderservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

interface ProductRepository extends CrudRepository<Product, Long> {}

@Service
public class ProductService implements CustomService<Product> {
    @Autowired
    ProductRepository repository;

    public List<Product> getAll() {
        List<Product> elems = new ArrayList<>();
        repository.findAll().forEach(elems::add);
        return elems;
    }

    public Product getById(long id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Product elem) {
        repository.save(elem);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}