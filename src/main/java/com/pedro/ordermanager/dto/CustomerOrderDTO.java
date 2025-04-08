package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.CustomerOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record CustomerOrderDTO (
                                //@NotNull
                                Long id,
                                //@NotBlank
                                LocalDate data,
                                Integer sizeItems) {
    public CustomerOrderDTO(CustomerOrder order){
        this(order.getId(), order.getData(), order.getProductsSize());
    }
}
