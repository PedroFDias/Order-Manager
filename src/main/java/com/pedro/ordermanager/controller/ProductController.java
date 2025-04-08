package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.ProductCreateDTO;
import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.dto.ProductUpdateDTO;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.services.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return service.get();
    }

    @GetMapping("page")
    public Page<ProductDTO> getProductsPage(Pageable pageable) {
        return service.getPage(pageable);
    }

    @GetMapping("/top5")
    public List<ProductDTO> top5MoreExpensive(){
        return service.getTop5();
    }

    @PostMapping
    @Transactional
    public void registerProduct(@RequestBody @Valid ProductCreateDTO data){
        service.post(data);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid ProductUpdateDTO data){
        service.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
