package com.play.fair.controller;


import com.play.fair.data.Product;
import com.play.fair.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductRepository repository;

    @Autowired
    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public List<Product> products() {
        return repository.findAll();
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> productsById(@PathVariable Long productId) {
        return repository.findById(productId);
    }
}
