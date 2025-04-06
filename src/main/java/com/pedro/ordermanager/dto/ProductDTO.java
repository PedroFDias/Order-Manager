package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Category;
import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProductDTO (
        @NotNull
        Long id,
        @NotBlank
        String name,
        @NotNull
        Double price,
        @NotNull
        Category category){

        public ProductDTO(Product product){
                this(product.getId(), product.getName(),product.getPrice(),product.getCategory());
        }
}
