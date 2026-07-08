package com.example.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank(message = "Category name is required")
        String name,
        @NotBlank(message = "Category description is required")
        String description) {
}
