package com.example.ecommerce.dto;

import java.math.BigDecimal;
import java.util.List;

public record CartResponse(Long userId, String userName, List<CartItemResponse> items, BigDecimal total) {
}
