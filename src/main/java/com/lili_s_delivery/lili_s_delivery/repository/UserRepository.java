package com.lili_s_delivery.lili_s_delivery.repository;

import com.lili_s_delivery.lili_s_delivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}