package com.spring.productservice.controller;

import com.spring.productservice.entity.Product;
import com.spring.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
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
        if(getProduct.isPresent()){
            product.setId(id);
            product=productService.save(product);
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }
    // patch update employee
    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchUpdateProduct(@RequestBody Product product, @PathVariable Long id){
        Optional<Product> getProduct= Optional.ofNullable(productService.getById(id));
        return getProduct.map(currrentValue -> {
            if(product.getName()!=null){
                currrentValue.setName(product.getName());
            }
            if(product.getDescription()!=null){
                currrentValue.setDescription(product.getDescription());
            }
            if(product.getPrice()!=null){
                currrentValue.setPrice(product.getPrice());
            }
            return currrentValue;
        }).map(productService::save).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // get all employees by page
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllProduct(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                                               @RequestParam(required = false, defaultValue = "9") Integer pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        List<Product> employeeList = new ArrayList<Product>();
        Page<Product> pageableList = productService.getPageableList(paging);
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
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    // delete all employees
    @DeleteMapping("/all")
    public ResponseEntity deleteAllProducts(List<Product> products){
        productService.deleteAll(products);
        return ResponseEntity.ok().build();
    }

}
