package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Category;
import com.pedro.ordermanager.model.Product;

public record ProductResponseDTO(Long id, String name, Double price, Category category) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice(), product.getCategory());
    }
    public ProductResponseDTO(ProductCreateDTO product){
        this(null, product.name(), product.price(), product.category());
    }
}
