package com.lili_s_delivery.lili_s_delivery.services;

import com.lili_s_delivery.lili_s_delivery.entity.User;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public class TokenService {

    private String secretKey = "your_secret_key"; // Store this securely
    private long expirationTime = 86400000; // Example: 1 day in milliseconds

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}