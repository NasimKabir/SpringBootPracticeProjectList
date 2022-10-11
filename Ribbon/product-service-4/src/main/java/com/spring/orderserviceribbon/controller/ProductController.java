package com.spring.orderserviceribbon.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    // get employee by id
    @GetMapping
    public ResponseEntity<String> getProductById(){
        return ResponseEntity.ok("Product with id: 5");
    }
}
