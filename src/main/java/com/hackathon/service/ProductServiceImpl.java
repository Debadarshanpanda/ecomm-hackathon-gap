package com.hackathon.service.impl;

import com.hackathon.dto.ProductDTO;
import com.hackathon.entity.Product;
import com.hackathon.repository.ProductRepository;
import com.hackathon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        List<Product> products = productRepository.findByProductPriceBetween(minPrice, maxPrice, pageable);

        return products.stream().map(product -> {
            ProductDTO dto = new ProductDTO();
            dto.setProductName(product.getProductName());
            dto.setProductPrice(product.getProductPrice());
            dto.setProductQuantity(product.getProductQuantity());
            dto.setCarbonFootprint(product.getCarbonFootprint());
            return dto;
        }).collect(Collectors.toList());
    }
}
