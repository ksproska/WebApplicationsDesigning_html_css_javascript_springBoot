package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {}
