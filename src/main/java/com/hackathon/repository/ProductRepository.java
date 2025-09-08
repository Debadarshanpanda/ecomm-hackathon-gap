package com.hackathon.repository;

import com.hackathon.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> findByProductPriceBetween(double minPrice, double maxPrice, Pageable pageable);
}

