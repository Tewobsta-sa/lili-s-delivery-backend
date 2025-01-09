package com.lili_s_delivery.lili_s_delivery.controller;

import com.lili_s_delivery.lili_s_delivery.entity.Order;
import com.lili_s_delivery.lili_s_delivery.services.OrderService;
import com.lili_s_delivery.lili_s_delivery.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestParam Long userId, @RequestParam String deliveryAddress) {
        Double totalPrice = cartService.calculateTotalPrice(userId);
        Order order = orderService.placeOrder(userId, deliveryAddress, totalPrice);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getUserOrders(userId));
    }
}