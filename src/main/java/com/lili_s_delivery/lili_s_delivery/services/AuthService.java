package com.lili_s_delivery.lili_s_delivery.services;

import com.lili_s_delivery.lili_s_delivery.entity.User;
import com.lili_s_delivery.lili_s_delivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenService tokenService; // Declare TokenService

    @Autowired
    public AuthService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.tokenService = tokenService; // Initialize it via constructor injection
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("CUSTOMER"); // Default role as CUSTOMER
        return userRepository.save(user);
    }

    public Optional<Map<String, Object>> authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful!");
            response.put("token", tokenService.generateToken(user.get())); // Correct usage
            response.put("user", Map.of(
                    "username", user.get().getUsername(),
                    "role", user.get().getRole()
            ));
            return Optional.of(response);
        }
        return Optional.empty();
    }
}