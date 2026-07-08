package com.example.ecommerce.service;

import com.example.ecommerce.dto.UserRegistrationRequest;
import com.example.ecommerce.dto.UserResponse;
import java.util.List;

public interface UserService {

    UserResponse registerUser(UserRegistrationRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);
}
