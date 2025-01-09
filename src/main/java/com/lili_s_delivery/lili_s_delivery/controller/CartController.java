package com.lili_s_delivery.lili_s_delivery.controller;

import com.lili_s_delivery.lili_s_delivery.entity.CartItem;
import com.lili_s_delivery.lili_s_delivery.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long userId, @RequestParam Long menuItemId, @RequestParam Integer quantity) {
        cartService.addToCart(userId, menuItemId, quantity);
        return ResponseEntity.ok("Item added to cart.");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartItem>> getUserCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getUserCart(userId));
    }
}