package com.spring.orderserviceribbon.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    // get employee by id
    @GetMapping
    public String getProductById(){
        return "Product with id: 1";
    }
}
