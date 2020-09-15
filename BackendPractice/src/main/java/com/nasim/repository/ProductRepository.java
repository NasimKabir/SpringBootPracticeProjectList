package com.nasim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasim.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
