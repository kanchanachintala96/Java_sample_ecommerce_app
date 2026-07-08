package com.example.ecommerce.dto;

import java.math.BigDecimal;

public record CartItemResponse(
        Long productId,
        String productName,
        Integer quantity,
        BigDecimal price,
        BigDecimal lineTotal) {
}
