package com.pedro.ordermanager.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CreateCustomerOrderDTO (
        @NotNull
        List<ItemDTO> items
) {
}
