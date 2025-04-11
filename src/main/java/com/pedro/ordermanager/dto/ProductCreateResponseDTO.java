package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Category;

public record ProductCreateResponseDTO(String name, Double price, Category category) {
    public ProductCreateResponseDTO(ProductCreateDTO product) {
        this(product.name(), product.price(), product.category());
    }
}
