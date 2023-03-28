package com.orderservice.orderservice.models;

import jakarta.persistence.*;

@Entity
@Table
public class Delivery {
    @Column(name = "id")
    private @Id
    @GeneratedValue Long id;
    @Column(name = "courier")
    private String courierName;
    @Column(name = "status")
    private DeliveryStatus status;


    public Delivery(String courierName, DeliveryStatus status) {
        this.courierName = courierName;
        this.status = status;
    }

    public Delivery() {}

    public Delivery(Long id, String courierName, DeliveryStatus status) {
        this.id = id;
        this.courierName = courierName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
