package com.play.fair.repository;


import com.play.fair.data.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByProductName(String productName);

    Product findById(long id);

    @Override
    List<Product> findAll();
}
