package com.spring.productservice.controller;

import com.spring.productservice.client.ProductClientService;
import com.spring.productservice.entity.Order;
import com.spring.productservice.model.Product;
import com.spring.productservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private final ProductClientService productClientService;

    // save employee
    @PostMapping
    public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order order) {
        order=orderService.save(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    // get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Order order=orderService.getById(id);
        return ResponseEntity.ok(order);
    }
    // update employee
    @PutMapping
    public ResponseEntity<Order>updateOrder(@RequestBody Order order, @RequestParam Long id){
        Optional<Order> getOrder= Optional.ofNullable(orderService.getById(id));
        if(getOrder.isPresent()){
            order.setId(id);
            order=orderService.save(order);
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }
    // patch update employee
    @PatchMapping("/{id}")
    public ResponseEntity<Order> patchUpdateOrder(@RequestBody Order order, @PathVariable Long id){
        Optional<Order> getOrder= Optional.ofNullable(orderService.getById(id));
        return getOrder.map(currrentValue -> {
            if(order.getName()!=null){
                currrentValue.setName(order.getName());
            }
            return currrentValue;
        }).map(orderService::save).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // get all employees by page
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllOrder(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                                               @RequestParam(required = false, defaultValue = "9") Integer pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        List<Order> orderListList = new ArrayList<Order>();
        Page<Order> pageableList = orderService.getPageableList(paging);
        pageableList.forEach(employee -> {
            orderListList.add(employee);
        });

        Map<String, Object> response = new HashMap<>();
        response.put("EmployeeList", orderListList);
        response.put("currentPage", pageableList.getNumber());
        response.put("totalItems", pageableList.getTotalElements());
        response.put("totalPages", pageableList.getTotalPages());
        response.put("nextPage", pageableList.hasNext());
        response.put("previousPage", pageableList.hasPrevious());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    // delete employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    // delete all employees
    @DeleteMapping("/all")
    public ResponseEntity deleteAllOrder(List<Order> orders){
        orderService.deleteAll(orders);
        return ResponseEntity.ok().build();
    }

    // get all employees by page
    @GetMapping("/products/all")
    public ResponseEntity<Map<String,Object>> getAllProducts(){
        return new ResponseEntity<>( productClientService.getAllProducts(),HttpStatus.OK);
    }
    // get product by id
    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productClientService.getProductById(id));
    }

    // save product
    @PostMapping("/products")
    public ResponseEntity saveProduct(@RequestBody Product order){
        return ResponseEntity.ok(productClientService.saveProduct(order));
    }

    // update product
    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product order, @RequestParam Long id){
       Product product= productClientService.updateProduct(order, id);
       log.info("product: {}",product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    // patch update product
    @PatchMapping("/products/{id}")
    public ResponseEntity<Product> patchUpdateProduct(@RequestBody Product product, @PathVariable Long id){
         product= productClientService.patchUpdateProduct(product, id);
         if(product.equals(null)){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
         }
        log.info("product: {}",product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
