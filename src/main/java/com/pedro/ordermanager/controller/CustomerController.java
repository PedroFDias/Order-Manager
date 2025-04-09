package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.CreateCustomerOrderDTO;
import com.pedro.ordermanager.dto.CustomerOrderDTO;
import com.pedro.ordermanager.services.CustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerOrderDTO> getOrders(){
        return service.get();
    }

    @PostMapping
    @Transactional
    public void postOrder(@RequestBody @Valid CreateCustomerOrderDTO data){
        service.post(data);
    }
}
