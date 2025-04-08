package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Category;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDTO(
        @NotNull
        Long id,
        String name,
        Double price,
        Category category){

}
