package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Item;
import jakarta.validation.constraints.NotNull;

public record ItemDTO(
        @NotNull
        Long productId,
        @NotNull
        Integer quantity)
{

        public ItemDTO(Item item){
                this(item.getProduct().getId(), item.getQuantity());
        }
}
