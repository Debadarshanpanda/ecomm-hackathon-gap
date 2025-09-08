package com.hackathon.controller;
import com.hackathon.dto.ProductDTO;
import com.hackathon.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    public ProductControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductsByPriceRange() {
        ProductDTO dto = new ProductDTO("Laptop", 50000.0, 10, 120.5);
        List<ProductDTO> expectedList = Arrays.asList(dto);

        when(productService.getProductsByPriceRange(40000.0, 60000.0, 0, 10, "productPrice")).thenReturn(expectedList);

        List<ProductDTO> result = productController.getProductsByPriceRange(40000.0, 60000.0, 0, 10, "productPrice");

        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getProductName());
    }
}

