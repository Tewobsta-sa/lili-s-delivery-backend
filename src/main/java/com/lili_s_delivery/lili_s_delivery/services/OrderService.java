package com.lili_s_delivery.lili_s_delivery.services;

import com.lili_s_delivery.lili_s_delivery.entity.Order;
import com.lili_s_delivery.lili_s_delivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Long userId, String deliveryAddress, Double totalPrice) {
        Order order = new Order();
        order.setUserId(userId);
        order.setDeliveryAddress(deliveryAddress);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}