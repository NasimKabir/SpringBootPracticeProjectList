package com.spring.productservice.client;

import com.spring.productservice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

import java.util.*;

@Service
@Slf4j
public class ProductClientService {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private WebClient webClient;



    // get all products
    public Map<String, Object> getAllProducts() {
        List<ServiceInstance> getInstances=discoveryClient.getInstances("product-service");
        String baseUrl=getInstances.get(0).getUri().toString();
        String url=baseUrl+"/api/v1/products/all";
        RestTemplate restTemplate=new RestTemplate();
        List<Product> products=restTemplate.getForObject(url, List.class);

        log.info("products: {}", products);
        //convert list to page
        Page<Product>pageableList =new PageImpl<>(products);
        Map<String, Object> response = new HashMap<>();
        response.put("EmployeeList", products);
        response.put("currentPage", pageableList.getNumber());
        response.put("totalItems", pageableList.getTotalElements());
        response.put("totalPages", pageableList.getTotalPages());
        response.put("nextPage", pageableList.hasNext());
        response.put("previousPage", pageableList.hasPrevious());
        log.info("response: {}", response);
        return response;
    }
    // get product by id
    public Product getProductById(Long id) {
        List<ServiceInstance> getInstances = discoveryClient.getInstances("product-service");
        String baseUrl = getInstances.get(0).getUri().toString();
        String url = baseUrl + "/api/v1/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(url, Product.class);
        log.info("product: {}", product);
        return product;
    }

    // save product
    public Product saveProduct(Product product) {
        List<ServiceInstance> getInstances = discoveryClient.getInstances("product-service");
        String baseUrl = getInstances.get(0).getUri().toString();
        String url = baseUrl + "/api/v1/products";
        RestTemplate restTemplate = new RestTemplate();
        Product savedProduct = restTemplate.postForObject(url, product, Product.class);
        log.info("savedProduct: {}", savedProduct);
        return savedProduct;
    }

    // update product
    public Product updateProduct(Product product, Long id) {
        List<ServiceInstance> getInstances = discoveryClient.getInstances("product-service");
        String baseUrl = getInstances.get(0).getUri().toString();
        String url = baseUrl + "/api/v1/products?id=" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, product, Product.class);
        // return product;
        return product;
    }

    // patch update product
    public Product patchUpdateProduct(Product product, Long id) {
        List<ServiceInstance> getInstances = discoveryClient.getInstances("product-service");
        String baseUrl = getInstances.get(0).getUri().toString();
        String url = baseUrl + "/api/v1/products/" + id;
        log.info("url: {}", url);
        RestTemplate restTemplate = new RestTemplate();
        Product updateProduct = restTemplate.patchForObject(url, product, Product.class);
        log.info("patched product: {}", updateProduct);
        return updateProduct;
    }
}
