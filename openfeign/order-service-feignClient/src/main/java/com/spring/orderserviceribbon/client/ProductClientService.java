package com.spring.orderserviceribbon.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service")
public interface ProductClientService {
    // list of products
    @GetMapping("/api/v1/products")
    String getProductMessage();
}
