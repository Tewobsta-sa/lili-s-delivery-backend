package com.lili_s_delivery.lili_s_delivery.repository;

import com.lili_s_delivery.lili_s_delivery.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
}