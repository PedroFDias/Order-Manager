package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.CategoryDTO;
import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> getProducts() {
        return repository.findAll().stream()
                .map(p -> new ProductDTO(p.getId(),p.getName(), p.getPrice(), new CategoryDTO(p.getCategory().getId(),p.getCategory().getName(),p.getCategory().getProductsSize())))
                .collect(Collectors.toList());
    }
}
