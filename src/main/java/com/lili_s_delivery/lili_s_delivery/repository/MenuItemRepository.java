package com.lili_s_delivery.lili_s_delivery.repository;
import com.lili_s_delivery.lili_s_delivery.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategory(String category);
}
