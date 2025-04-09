package com.pedro.ordermanager.dto;

import jakarta.validation.constraints.NotNull;

public record ItemDTO(
        @NotNull
        Long productId,
        @NotNull
        Integer quantity
) {
}
