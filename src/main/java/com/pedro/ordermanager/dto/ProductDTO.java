package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Category;
import com.pedro.ordermanager.model.CustomerOrder;

import java.util.List;

public record ProductDTO (Long id,
                          String name,
                          Double price,
                          CategoryDTO category){
}
