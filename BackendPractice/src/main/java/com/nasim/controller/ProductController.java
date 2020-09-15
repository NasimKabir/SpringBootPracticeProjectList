package com.nasim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasim.model.Product;
import com.nasim.service.ProductService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {
 
	@Autowired
    private ProductService productService;
 
    @GetMapping
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @PostMapping
    public Product saveProduct(Product product) {
    	return productService.save(product);
    }
}