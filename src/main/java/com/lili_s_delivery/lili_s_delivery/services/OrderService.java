package com.lili_s_delivery.lili_s_delivery.services;

import com.lili_s_delivery.lili_s_delivery.entity.Orders;
import com.lili_s_delivery.lili_s_delivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    public List<Orders> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}