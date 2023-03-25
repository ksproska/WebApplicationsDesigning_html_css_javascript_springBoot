package com.orderservice.orderservice.services;

import com.orderservice.orderservice.models.Delivery;
import com.orderservice.orderservice.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {}
