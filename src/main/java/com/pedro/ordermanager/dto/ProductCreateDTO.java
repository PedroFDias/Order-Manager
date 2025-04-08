package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Category;
import com.pedro.ordermanager.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCreateDTO(
                              @NotBlank
                              String name,
                              @NotNull
                              Double price,
                              @NotNull
                              Category category) {

    public ProductCreateDTO(Product product) {
        this(product.getName(), product.getPrice(), product.getCategory());
    }

}
