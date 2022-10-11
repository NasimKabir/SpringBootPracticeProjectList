package com.spring.orderserviceribbon.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductClientService {
    private final RestTemplate restTemplate;

    // get all products
    public String getMessage() {
        String url="http://product-service/api/v1/products";
        log.info("url: {}", url);
        String response=restTemplate.getForObject(url,String.class);
        log.info("response: {}", response);
        return response;
    }
}
