package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
