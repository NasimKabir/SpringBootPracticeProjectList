package com.nasim.service;

import com.nasim.model.Product;

public interface ProductService {
    public Iterable<Product> getAllProducts();
 
    public Product getProduct(long id);
 
    public Product save(Product product);
}
