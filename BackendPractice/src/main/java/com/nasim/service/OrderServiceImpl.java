package com.nasim.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasim.model.Order;
import com.nasim.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
 
    // orderRepository constructor injection
	@Autowired
	private OrderRepository orderRepository;
 
    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
	
    @Override
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }
 
    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}