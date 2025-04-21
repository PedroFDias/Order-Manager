package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Item;

public record ItemResponseDTO(
        Long productId,
        String productName,
        Integer quantity,
        Double price) {
    public ItemResponseDTO(Item item) {
        this(
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getQuantity(),
                item.getProduct().getPrice()
        );
    }
}
