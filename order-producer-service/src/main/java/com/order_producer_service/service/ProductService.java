package com.order_producer_service.service;

import com.order_producer_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String PREFIX = "product:";

    // Save product to cache
    public void saveProduct(Product product) {
        redisTemplate.opsForValue().set(PREFIX + product.getId(), product);
    }

    // Get product (frequently accessed)
    public Product getProduct(String id) {
        return (Product) redisTemplate.opsForValue().get(PREFIX + id);
    }
}