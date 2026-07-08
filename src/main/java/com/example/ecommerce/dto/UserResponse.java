package com.example.ecommerce.dto;

import com.example.ecommerce.entity.UserRole;

public record UserResponse(Long id, String name, String email, UserRole role) {
}
