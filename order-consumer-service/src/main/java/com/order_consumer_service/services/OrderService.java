package com.order_consumer_service.services;

import com.order_producer_service.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String PREFIX = "order:";

    public void processOrder(com.order_producer_service.entity.Order order) {

        // Step 1: Mark as PENDING
        redisTemplate.opsForValue().set(PREFIX + order.getOrderId(), "PENDING");

        // Simulate processing
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        // Step 2: Mark as COMPLETED
        redisTemplate.opsForValue().set(PREFIX + order.getOrderId(), "COMPLETED");
    }
}