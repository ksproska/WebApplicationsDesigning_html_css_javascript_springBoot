package com.orderservice.orderservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

////@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "items")
public class OrderItem {
    @Column(name = "id")
    private @Id
    @GeneratedValue Long id;
    @JoinColumn(name = "product")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;
    @Column(name = "quality")
    private Integer quality;

    public OrderItem(Integer quality) {
        this.quality = quality;
    }

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
