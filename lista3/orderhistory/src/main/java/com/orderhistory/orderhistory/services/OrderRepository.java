package com.orderhistory.orderhistory.services;

import com.orderhistory.orderhistory.models.OrderHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderHistory, Long> {

    @Query("SELECT h FROM OrderHistory h WHERE UPPER(h.consumerName) LIKE CONCAT('%',UPPER(?1),'%')")
    List<OrderHistory> findAllForConsumerName(String firstNameFilter);

    @Query("SELECT h FROM OrderHistory h WHERE UPPER(h.consumerName) LIKE CONCAT('%',UPPER(?1),'%')")
    Page<OrderHistory> findAllForConsumerName(String firstNameFilter, Pageable pageable);
}
