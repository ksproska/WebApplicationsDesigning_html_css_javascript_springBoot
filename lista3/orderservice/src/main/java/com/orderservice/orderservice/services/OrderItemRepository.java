package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
