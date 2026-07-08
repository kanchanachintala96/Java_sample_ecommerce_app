package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderResponse;
import java.util.List;

public interface OrderService {

    OrderResponse placeOrder(Long userId);

    List<OrderResponse> getOrdersByUserId(Long userId);

    OrderResponse getOrderById(Long orderId);
}
