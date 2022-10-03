package com.spring.productservice.service.impl;

import com.spring.productservice.entity.Order;
import com.spring.productservice.repository.OrderRepository;
import com.spring.productservice.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends CustomServiceImpl<Order, Long> implements OrderService {
    public OrderServiceImpl( OrderRepository repository) {
        super(repository);
    }
}
