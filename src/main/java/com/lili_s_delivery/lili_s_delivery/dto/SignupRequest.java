package com.lili_s_delivery.lili_s_delivery.dto;

public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getPhone() { return phoneNumber; }
    public void setPhone(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
