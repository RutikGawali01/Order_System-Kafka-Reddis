package com.order_consumer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class CacheController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/{orderId}")
    public Object getStatus(@PathVariable String orderId) {

        System.out.println("API HIT");

        Object value = redisTemplate.opsForValue().get("order:" + orderId);

        System.out.println("VALUE FETCHED: " + value);

        return value;
    }
}
