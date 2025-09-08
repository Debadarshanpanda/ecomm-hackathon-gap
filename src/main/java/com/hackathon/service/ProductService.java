package com.hackathon.service;

import com.hackathon.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductsByPriceRange(double minPrice, double maxPrice, int page, int size, String sortBy);
}
