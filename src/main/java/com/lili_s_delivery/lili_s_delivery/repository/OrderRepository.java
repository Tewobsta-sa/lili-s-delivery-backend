package com.lili_s_delivery.lili_s_delivery.repository;

import com.lili_s_delivery.lili_s_delivery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}