package com.hackathon.service;
import com.hackathon.dto.ProductDTO;
import com.hackathon.entity.Product;
import com.hackathon.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private com.hackathon.service.impl.ProductServiceImpl productService;

    public ProductServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductsByPriceRange() {
        Product product = new Product();
        product.setProductPrice(40000.0);
        product.setProductName("mobile");
        List<Product> productList = List.of(product);

        Pageable pageable = PageRequest.of(0, 10, Sort.by("productPrice"));
        when(productRepository.findByProductPriceBetween(40000.0, 60000.0, pageable)).thenReturn(productList);

        List<ProductDTO> result = productService.getProductsByPriceRange(40000.0, 60000.0, 0, 10, "productPrice");

        assertEquals(1, result.size());
        assertEquals("mobile", result.get(0).getProductName());
        assertEquals(40000.0, result.get(0).getProductPrice());
    }
}
