package com.orderservice.orderservice.models;

import jakarta.persistence.*;

import java.util.List;

//enum DeliveryStatus {
//    delivered,
//}
//
////@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//@Entity
//@Table
//class Delivery {
//    private @Id
//    @GeneratedValue Long id;
//    private String courierName;
//    private DeliveryStatus status;
//
//
//    public Delivery(Long id, String courierName, DeliveryStatus status) {
//        this.id = id;
//        this.courierName = courierName;
//        this.status = status;
//    }
//
//    public Delivery() {
//
//    }
//}

@Entity
@Table(name = "orders")
public class Order {
    @Column(name = "id")
    private @Id
    @GeneratedValue Long id;
    @Column(name = "consumer")
    private String consumerName;
    @Column(name = "items")
    @OneToMany
    private List<OrderItem> orderItems;
//    private Delivery delivery;

    public Order(Long id, String consumerName) {
        this.id = id;
        this.consumerName = consumerName;
//        this.orderItems = orderItems;
//        this.delivery = delivery;
    }

    public Order() {}

    public Order(String consumerName) {
        this.consumerName = consumerName;
    }

    public Long getId() {
        return id;
    }

//    @OneToMany
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
//
//    @ManyToOne
//    public Delivery getDelivery() {
//        return delivery;
//    }
//
//    public void setDelivery(Delivery delivery) {
//        this.delivery = delivery;
//    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + consumerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }
}
