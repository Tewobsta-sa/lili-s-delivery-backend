package com.lili_s_delivery.lili_s_delivery.repository;

import com.lili_s_delivery.lili_s_delivery.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByUserId(Long userId);
}
