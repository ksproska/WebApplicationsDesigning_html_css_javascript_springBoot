package com.orderhistory.orderhistory.services;

import com.orderhistory.orderhistory.models.OrderHistory;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderHistory, Long> {
}
