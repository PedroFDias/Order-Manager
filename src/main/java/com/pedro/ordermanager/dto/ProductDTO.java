package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Category;
import com.pedro.ordermanager.model.CustomerOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProductDTO (
        @NotBlank
        String name,
        @NotNull
        Double price,
        @NotNull
        Category category){
}
