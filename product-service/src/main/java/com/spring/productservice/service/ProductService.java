package com.spring.productservice.service;

import com.spring.productservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService{
    Page<Product> getAll(Pageable pageable);
    // get by id
    Product getById(Long id);
    // save
    Product save(Product product);
    // delete
    void delete(Long id);
    // update
    Optional<Product> update(Product product, Long id);
}
