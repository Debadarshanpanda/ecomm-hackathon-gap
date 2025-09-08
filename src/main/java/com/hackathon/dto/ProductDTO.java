package com.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private double carbonFootprint;

    // Getters and Setters
}
