package com.order_consumer_service.services;

import com.order_producer_service.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "order-topic", groupId = "group1")
    public void consume(Order order) {
        System.out.println("Received Order: " + order);
        orderService.processOrder(order);
    }
}