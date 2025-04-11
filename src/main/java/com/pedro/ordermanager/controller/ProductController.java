package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.ProductCreateDTO;
import com.pedro.ordermanager.dto.ProductResponseDTO;
import com.pedro.ordermanager.dto.ProductUpdateDTO;
import com.pedro.ordermanager.services.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        var products = service.get();
        return ResponseEntity.ok(products);
    }

    @GetMapping("page")
    public ResponseEntity<Page<ProductResponseDTO>> getProductsPage(Pageable pageable) {
        var pages = service.getPage(pageable);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<ProductResponseDTO>> top5MoreExpensive(){
        var products = service.getTop5();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    @Transactional
    public ResponseEntity registerProduct(@RequestBody @Valid ProductCreateDTO data){
        var response = service.post(data);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ProductUpdateDTO data){
        var response = service.update(data);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var data = service.delete(id);
        return ResponseEntity.ok(data);
    }

}
