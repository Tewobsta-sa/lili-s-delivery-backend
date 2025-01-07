package com.lili_s_delivery.lili_s_delivery.controller;

import com.lili_s_delivery.lili_s_delivery.entity.Orders;
import com.lili_s_delivery.lili_s_delivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/user/{userId}")
    public List<Orders> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }
}
