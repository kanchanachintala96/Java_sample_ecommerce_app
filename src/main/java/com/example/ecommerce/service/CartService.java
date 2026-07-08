package com.example.ecommerce.service;

import com.example.ecommerce.dto.CartItemRequest;
import com.example.ecommerce.dto.CartResponse;

public interface CartService {

    CartResponse getCartByUserId(Long userId);

    CartResponse addItemToCart(Long userId, CartItemRequest request);

    CartResponse removeItemFromCart(Long userId, Long productId);

    void clearCart(Long userId);
}
