package com.nasim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nasim.model.Order;
import com.nasim.model.OrderProduct;
import com.nasim.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
 
	@Autowired
    private OrderService orderService;
 
	@PostMapping
	public ResponseEntity<Order> create(@RequestBody Order order) {
	    List<OrderProduct> orderProducts = order.getOrderProducts();
	   // validateProductsExistence(formDtos);
	    // create order logic
	    // populate order with products
	 
	    order.setOrderProducts(orderProducts);
	    this.orderService.update(order);
	 
	    String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/orders/{id}").buildAndExpand(order.getId()).toString();
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Location", uri);
	 
	    return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}
}