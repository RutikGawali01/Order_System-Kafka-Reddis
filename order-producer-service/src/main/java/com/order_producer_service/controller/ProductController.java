package com.order_producer_service.controller;

import com.order_producer_service.entity.Product;
import com.order_producer_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // redis implementation  in this api
    @PostMapping
    public String addProduct(@RequestBody Product product) {
            service.saveProduct(product);
        return "Product cached in Redis!";
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return service.getProduct(id);
    }
}