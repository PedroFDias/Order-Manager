package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.repository.ItemRepository;

import java.time.LocalDate;
import java.util.List;

public record CustomerResponseDTO (
        Long id,
        LocalDate date,
        Integer totalItems,
        List<ItemResponseDTO> items){
    public CustomerResponseDTO(CustomerOrder order){
        this(order.getId(), order.getDate(), order.getTotalItems(), order.getItems().stream()
                .map(ItemResponseDTO::new)
                .toList());
    }
}
