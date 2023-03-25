package com.orderservice.orderservice;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class OrderItem {
    private Long id;
    private Product product;
    private Integer quality;

    public OrderItem(Long id, Product product, Integer quality) {
        this.id = id;
        this.product = product;
        this.quality = quality;
    }
}

enum DeliveryStatus {
delivered,
}
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Delivery {
    private Long id;
    private String courierName;
    private DeliveryStatus status;


    public Delivery(Long id, String courierName, DeliveryStatus status) {
        this.id = id;
        this.courierName = courierName;
        this.status = status;
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//@Entity
public class Order {
    private Long id;
    private String consumerName;
    private List<OrderItem> orderItems;
    private Delivery delivery;

    public Order(Long id, String consumerName, List<OrderItem> orderItems, Delivery delivery) {
        this.id = id;
        this.consumerName = consumerName;
        this.orderItems = orderItems;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }
}
