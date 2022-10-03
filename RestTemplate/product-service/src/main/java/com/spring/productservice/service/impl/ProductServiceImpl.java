package com.spring.productservice.service.impl;

import com.spring.productservice.entity.Product;
import com.spring.productservice.repository.ProductRepository;
import com.spring.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        if(products.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No products found");
        }
        return products;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
    }

    @Override
    public Product save(Product product) {
        if(product.getPrice()==null || product.getName()==null || product.getDescription()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Required fields are missing");
        }
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.
                findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> update(Product product, Long id) {
        return productRepository.findById(id).map(currentValue -> {
            if(product.getName()!=null){
                currentValue.setName(product.getName());
            }
            if(product.getDescription()!=null){
                currentValue.setDescription(product.getDescription());
            }
            if(product.getPrice()!=null){
                currentValue.setPrice(product.getPrice());
            }
            return productRepository.save(currentValue);
        });
    }
}
