package com.order_producer_service.controller;

import com.order_producer_service.entity.Order;
import com.order_producer_service.service.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducer producer;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        producer.sendOrder(order);
        return "Order sent to Kafka!";
    }
}