package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return service.getProducts();
    }

}
