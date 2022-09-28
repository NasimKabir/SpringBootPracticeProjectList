package com.spring.productservice.service.impl;

import com.spring.productservice.entity.Product;
import com.spring.productservice.repository.ProductRepository;
import com.spring.productservice.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends CustomServiceImpl<Product, Long> implements ProductService {
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
