package com.orderservice.orderservice;

import com.orderservice.orderservice.models.OrderItem;
import com.orderservice.orderservice.models.Product;
import com.orderservice.orderservice.services.OrderItemRepository;
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
        orderItemRepository.saveAll(new ArrayList<>() {
            {
                add(new OrderItem(book, 2));
                add(new OrderItem(chair, 3));
            }
        });
    }
}
