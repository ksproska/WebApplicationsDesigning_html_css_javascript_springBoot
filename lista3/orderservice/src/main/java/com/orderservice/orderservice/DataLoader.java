package com.orderservice.orderservice;

import com.orderservice.orderservice.models.*;
import com.orderservice.orderservice.services.DeliveryRepository;
import com.orderservice.orderservice.services.OrderItemRepository;
import com.orderservice.orderservice.services.OrderRepository;
import com.orderservice.orderservice.services.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class DataLoader {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Bean
    void LoadData() {
        var book = new Product("book", new BigDecimal(14));
        var chair = new Product("chair", new BigDecimal(100));
        productRepository.saveAll(new ArrayList<>(){
            {
                add(book);
                add(chair);
                add(new Product("doll", new BigDecimal(20)));
            }
        });
        var items = new ArrayList<OrderItem>() {
            {
                add(new OrderItem(book, 2));
                add(new OrderItem(chair, 3));
            }
        };
        orderItemRepository.saveAll(items);
        var created = new Delivery("Kacper Listonosz", DeliveryStatus.Created);
        deliveryRepository.saveAll(new ArrayList<>(){
            {
                add(created);
            }
        });
    }
}
