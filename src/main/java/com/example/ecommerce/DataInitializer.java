package com.example.ecommerce;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.entity.UserRole;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    public DataInitializer(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            UserRepository userRepository,
            CartRepository cartRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() > 0 || productRepository.count() > 0 || userRepository.count() > 0) {
            return;
        }

        Category electronics = createCategory("Electronics", "Devices and gadgets");
        Category clothing = createCategory("Clothing", "Everyday fashion and apparel");
        Category books = createCategory("Books", "Fiction, non-fiction, and learning resources");
        categoryRepository.saveAll(List.of(electronics, clothing, books));

        productRepository.saveAll(List.of(
                createProduct("Laptop", "15-inch productivity laptop", new BigDecimal("899.99"), 25, electronics),
                createProduct("Wireless Headphones", "Noise-cancelling over-ear headphones", new BigDecimal("199.99"), 40, electronics),
                createProduct("Denim Jacket", "Classic blue denim jacket", new BigDecimal("79.99"), 30, clothing),
                createProduct("Running Shoes", "Lightweight running shoes", new BigDecimal("119.99"), 35, clothing),
                createProduct("Spring Boot in Action", "Hands-on guide to Spring Boot", new BigDecimal("49.99"), 50, books),
                createProduct("Clean Code", "Software craftsmanship best practices", new BigDecimal("39.99"), 45, books)));

        User admin = createUser("Admin User", "admin@example.com", "admin123", UserRole.ADMIN);
        User customer = createUser("Customer User", "customer@example.com", "customer123", UserRole.CUSTOMER);
        userRepository.saveAll(List.of(admin, customer));

        cartRepository.saveAll(List.of(createCart(admin), createCart(customer)));
    }

    private Category createCategory(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return category;
    }

    private Product createProduct(String name, String description, BigDecimal price, int stockQuantity, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setCategory(category);
        return product;
    }

    private User createUser(String name, String email, String password, UserRole role) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        return user;
    }

    private Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);
        return cart;
    }
}
