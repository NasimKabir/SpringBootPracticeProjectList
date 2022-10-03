package com.spring.productservice.controller;

import com.spring.productservice.entity.Product;
import com.spring.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    // save employee
    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        product=productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product=productService.getById(id);
        return ResponseEntity.ok(product);
    }
    // update employee
    @PutMapping
    public ResponseEntity<Product>updateProduct(@RequestBody Product product, @RequestParam Long id){
        Optional<Product> getProduct= Optional.ofNullable(productService.getById(id));
        log.info("getProduct: {}",getProduct);
        if(getProduct.isPresent()){
            product.setId(id);
            product=productService.save(product);
            return ResponseEntity.ok(product);
        }
        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
    // patch update employee
    @PatchMapping("/{id}")
    public Optional<Product> patchUpdateProduct(@RequestBody Product product, @PathVariable Long id){
        return productService.update(product,id);
    }

    // get all employees by page
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllProduct(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                                             @RequestParam(required = false, defaultValue = "9") Integer pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        List<Product> employeeList = new ArrayList<Product>();
        Page<Product> pageableList = productService.getAll(paging);
        pageableList.forEach(employee -> {
            employeeList.add(employee);
        });

        Map<String, Object> response = new HashMap<>();
        response.put("EmployeeList", employeeList);
        response.put("currentPage", pageableList.getNumber());
        response.put("totalItems", pageableList.getTotalElements());
        response.put("totalPages", pageableList.getTotalPages());
        response.put("nextPage", pageableList.hasNext());
        response.put("previousPage", pageableList.hasPrevious());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    // delete employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }


}
