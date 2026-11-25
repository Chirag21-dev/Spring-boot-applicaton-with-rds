package com.eustache.spring_rds_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eustache.spring_rds_demo.model.Product;
import com.eustache.spring_rds_demo.repository.ProductRepository;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
    @PostMapping("/product")
    public ResponseEntity<String> createProduct(
        @RequestBody Product product
    ){
        if (product != null) {
            productRepository.save(product);
            return ResponseEntity.ok("Product created successfully");
        }
        return ResponseEntity.badRequest().body("Product cannot be null");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }
}
