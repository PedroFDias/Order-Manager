package com.pedro.ordermanager.dto;

import com.pedro.ordermanager.model.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public record CategoryDTO(Long id,
                          String name,
                          Integer productsSize){
        }
