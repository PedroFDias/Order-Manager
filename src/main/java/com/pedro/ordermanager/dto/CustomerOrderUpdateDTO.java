package com.pedro.ordermanager.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CustomerOrderUpdateDTO(
        @NotNull
        Long id,
        LocalDate date,
        Integer totalItems,
        List<ItemDTO> items
        ) {
}
