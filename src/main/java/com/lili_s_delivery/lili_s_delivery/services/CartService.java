package com.lili_s_delivery.lili_s_delivery.services;

import com.lili_s_delivery.lili_s_delivery.entity.CartItem;
import com.lili_s_delivery.lili_s_delivery.entity.MenuItem;
import com.lili_s_delivery.lili_s_delivery.repository.CartRepository;
import com.lili_s_delivery.lili_s_delivery.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public void addToCart(Long userId, Long menuItemId, Integer quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setUserId(userId);
        cartItem.setMenuItemId(menuItemId);
        cartItem.setQuantity(quantity);
        cartRepository.save(cartItem);
    }

    public List<CartItem> getUserCart(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Double calculateTotalPrice(Long userId) {
        List<CartItem> cartItems = getUserCart(userId);
        return cartItems.stream()
                .mapToDouble(cartItem -> {
                    MenuItem menuItem = menuItemRepository.findById(cartItem.getMenuItemId()).orElse(null);
                    return menuItem != null ? menuItem.getPrice() * cartItem.getQuantity() : 0;
                })
                .sum();
    }
}