package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.services.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/top5")
    public List<ProductDTO> top5MoreExpensive(){
        return service.getTop5MoreExpensive();
    }

    @PostMapping
    @Transactional
    public void registerProduct(@RequestBody @Valid ProductDTO json){
        service.postProducts(json);
    }

}
