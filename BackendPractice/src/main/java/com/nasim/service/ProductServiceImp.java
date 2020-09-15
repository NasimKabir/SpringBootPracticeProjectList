package com.nasim.service;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasim.model.Product;
import com.nasim.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {
		return productRepository.findById(id)
				.orElseThrow(()-> new RuntimeErrorException(null, "Product "+id+" not found"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
}
