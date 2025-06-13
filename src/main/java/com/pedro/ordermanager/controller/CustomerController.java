package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.CreateCustomerOrderDTO;
import com.pedro.ordermanager.dto.CustomerOrderUpdateDTO;
import com.pedro.ordermanager.dto.CustomerResponseDTO;
import com.pedro.ordermanager.services.CustomerOrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/customer")
@SecurityRequirement(name = "bearer-key")
public class CustomerController {
    @Autowired
    private CustomerOrderService service;

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getOrders(){
        var response = service.get();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity getOrder(@PathVariable Long id){
        var response = service.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postOrder(@RequestBody @Valid CreateCustomerOrderDTO data, UriComponentsBuilder uriBuilder){
        var response = service.post(data);
        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid CustomerOrderUpdateDTO data){
        var response = service.update(data);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var response = service.delete(id);
        return ResponseEntity.ok(response);
    }
}
