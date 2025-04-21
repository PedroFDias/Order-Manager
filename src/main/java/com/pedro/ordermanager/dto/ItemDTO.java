package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Item;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

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
