package com.order_consumer_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    private String orderId;
    private String status; // PENDING, COMPLETED
}
