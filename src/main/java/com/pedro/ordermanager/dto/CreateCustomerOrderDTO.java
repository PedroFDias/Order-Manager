package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Item;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateCustomerOrderDTO (
        @NotNull
        List<ItemDTO> items
) {
}
