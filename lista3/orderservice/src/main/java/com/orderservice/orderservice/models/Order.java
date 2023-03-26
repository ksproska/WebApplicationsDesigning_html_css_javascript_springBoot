package com.orderservice.orderservice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

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
    @JoinColumn(name = "delivery")
    @OneToOne(cascade = {CascadeType.ALL})
    private Delivery delivery;

    public Order() {}

    public Order(Long id, String consumerName, List<OrderItem> orderItems, Delivery delivery) {
        this.id = id;
        this.consumerName = consumerName;
        this.orderItems = orderItems;
        this.delivery = delivery;
    }

    public Order(String consumerName, List<OrderItem> orderItems, Delivery delivery) {
        this.consumerName = consumerName;
        this.orderItems = orderItems;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

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

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
