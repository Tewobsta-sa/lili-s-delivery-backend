package com.lili_s_delivery.lili_s_delivery.services;

import com.lili_s_delivery.lili_s_delivery.entity.MenuItem;
import com.lili_s_delivery.lili_s_delivery.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem saveMenuItem(MenuItem item) {
        return menuItemRepository.save(item);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}
