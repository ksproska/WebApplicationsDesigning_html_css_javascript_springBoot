package com.orderhistory.orderhistory.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Entity
@Table(name = "order_history")
public class OrderHistory extends RepresentationModel<OrderHistory> {
    @Column(name = "order_id")
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Column(name = "consumer_name")
    private String consumerName;
    @Column(name = "courier_name")
    private String courierName;
    @Column(name = "delivery_status")
    private String deliveryStatus;
    @Column(name = "product_names")
    private String productNames;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public OrderHistory() {}

    public OrderHistory(Long id, String consumerName, String courierName, String deliveryStatus, String productNames, BigDecimal totalPrice) {
        this.id = id;
        this.consumerName = consumerName;
        this.courierName = courierName;
        this.deliveryStatus = deliveryStatus;
        this.productNames = productNames;
        this.totalPrice = totalPrice;
    }

    public OrderHistory(String consumerName, String courierName, String deliveryStatus, String productNames, BigDecimal totalPrice) {
        this.consumerName = consumerName;
        this.courierName = courierName;
        this.deliveryStatus = deliveryStatus;
        this.productNames = productNames;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
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

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
