package com.example.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long orderId,
        Long userId,
        String userName,
        LocalDateTime orderDate,
        List<OrderItemResponse> items,
        BigDecimal total) {
}
