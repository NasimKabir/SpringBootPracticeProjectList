package com.spring.productservice.client;

import com.spring.productservice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ProductClientService {
    @Autowired
    DiscoveryClient discoveryClient;

    // get all products
    public List<Product> getAllProducts() {
        List<ServiceInstance> getInstances=discoveryClient.getInstances("product-service");
        String baseUrl=getInstances.get(0).getUri().toString();
        String url=baseUrl+"/api/v1/products/all";
        RestTemplate restTemplate=new RestTemplate();
        List<Product> products=restTemplate.getForObject(url, List.class);
        log.info("products: {}", products);
        return products;
    }
    // get product by id
    public Product getProductById(Long id) {
        List<ServiceInstance> getInstances=discoveryClient.getInstances("product-service");
        String baseUrl=getInstances.get(0).getUri().toString();
        String url=baseUrl+"/api/v1/products/"+id;
        RestTemplate restTemplate=new RestTemplate();
        Product product=restTemplate.getForObject(url, Product.class);
        log.info("product: {}", product);
        return product;
    }
    // save product
    public Product saveProduct(Product product) {
        List<ServiceInstance> getInstances=discoveryClient.getInstances("product-service");
        String baseUrl=getInstances.get(0).getUri().toString();
        String url=baseUrl+"/api/v1/products";
        RestTemplate restTemplate=new RestTemplate();
        Product savedProduct=restTemplate.postForObject(url, product, Product.class);
        log.info("savedProduct: {}", savedProduct);
        return savedProduct;
    }
    // update product
    public void updateProduct(Product product, Long id) {
        List<ServiceInstance> getInstances=discoveryClient.getInstances("product-service");
        String baseUrl=getInstances.get(0).getUri().toString();
        String url=baseUrl+"/api/v1/products?id="+id;
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.put(url, product,Product.class);
       // return product;
    }
}
