package com.nasim.service;

import java.time.LocalDate;

import com.nasim.model.Order;

public interface OrderService {
	 public Iterable<Order> getAllOrders();
	       
	    public Order create(Order order); 
	    public void update(Order order);
}
