package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.CustomerOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CustomerOrderDTO (
                                @NotNull
                                Long id,
                                @NotNull
                                LocalDate date,
                                @NotNull
                                Integer totalItems) {
    public CustomerOrderDTO(CustomerOrder order){
        this(order.getId(), order.getDate(), order.getTotalItems());
    }
}
