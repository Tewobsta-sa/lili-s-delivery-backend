package com.lili_s_delivery.lili_s_delivery.controller;

import com.lili_s_delivery.lili_s_delivery.entity.MenuItem;
import com.lili_s_delivery.lili_s_delivery.repository.MenuItemRepository;
import com.lili_s_delivery.lili_s_delivery.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    // Add a new menu item
    @PostMapping
    public ResponseEntity<?> addMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem savedItem = menuItemRepository.save(menuItem);
        return ResponseEntity.ok(savedItem);
    }

    // Get all menu items
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(menuItemRepository.findAll());
    }

    // Update a menu item
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem updatedItem) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        menuItem.setName(updatedItem.getName());
        menuItem.setCategory(updatedItem.getCategory());
        menuItem.setPrice(updatedItem.getPrice());
        menuItemRepository.save(menuItem);

        return ResponseEntity.ok(menuItem);
    }

    // Delete a menu item
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable Long id) {
        menuItemRepository.deleteById(id);
        return ResponseEntity.ok("Menu item deleted successfully");
    }


}
