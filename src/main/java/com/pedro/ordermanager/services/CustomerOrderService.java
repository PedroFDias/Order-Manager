package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.*;
import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Item;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.repository.CustomerOrderRepository;
import com.pedro.ordermanager.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository repository;
    @Autowired
    private ProductRepository productRepository;

    public List<CustomerResponseDTO> get(){
        return convertData(repository.findAll());
    }

    public CustomerResponseDTO get(Long id){
        return new CustomerResponseDTO(repository.getReferenceById(id));
    }

    public CustomerOrderDTO post(CreateCustomerOrderDTO dto) {
        List<Item> items = new ArrayList<>();

        for (ItemDTO itemDTO : dto.items()) {
            Product product = productRepository.findById(itemDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + itemDTO.productId()));

            Item item = new Item();
            item.setProduct(product);
            item.setQuantity(itemDTO.quantity());
            items.add(item);
        }

        CustomerOrder order = new CustomerOrder();
        for (Item item : items) {
            item.setOrder(order);
        }
        order.setItems(items);
        order.setTotalItems();

        repository.save(order);
        return new CustomerOrderDTO(order);
    }

    private List<CustomerResponseDTO> convertData(List<CustomerOrder> order) {
        return order.stream()
                .map(CustomerResponseDTO::new)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO update(CustomerOrderUpdateDTO data) {
        var order = repository.getReferenceById(data.id());

        List<Item> items = new ArrayList<>();
        for (ItemDTO itemDTO : data.items()) {
            Product product = productRepository.findById(itemDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + itemDTO.productId()));

            Item item = new Item();
            item.setProduct(product);
            item.setQuantity(itemDTO.quantity());
            items.add(item);
        }

        order.updateOrder(data, items); // Envia os novos itens

        repository.save(order);
        return new CustomerResponseDTO(order);
    }

    public CustomerResponseDTO delete(Long id){
        var customer = repository.getReferenceById(id);
        repository.delete(customer);
        return new CustomerResponseDTO(customer);
    }
}
