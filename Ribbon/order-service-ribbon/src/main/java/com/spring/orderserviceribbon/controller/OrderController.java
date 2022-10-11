package com.spring.orderserviceribbon.controller;


import com.spring.orderserviceribbon.client.ProductClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ProductClientService productClientService;

    // get employee by id
    @GetMapping
    public String getProductById(){
        return productClientService.getMessage();
    }
}
