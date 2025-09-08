package com.hackathon.controller;

import com.hackathon.dto.ProductDTO;
import com.hackathon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/by-price")
    public List<ProductDTO> getProductsByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "productPrice") String sortBy) {

        return productService.getProductsByPriceRange(minPrice, maxPrice, page, size, sortBy);
    }
}
