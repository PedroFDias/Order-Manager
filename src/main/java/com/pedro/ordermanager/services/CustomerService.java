package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.CustomerOrderDTO;
import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.repository.CustomerOrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerOrderRepository repository;

    public List<CustomerOrderDTO> get(){
        return convertData(repository.findAll());
    }
    private List<CustomerOrderDTO> convertData(List<CustomerOrder> order) {
        return order.stream()
                .map(CustomerOrderDTO::new)
                .collect(Collectors.toList());
    }

    public void post(@Valid CustomerOrderDTO order) {
        repository.save(new CustomerOrder(order));
    }
}
