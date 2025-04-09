package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.CreateCustomerOrderDTO;
import com.pedro.ordermanager.dto.CustomerOrderDTO;
import com.pedro.ordermanager.dto.ItemDTO;
import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Item;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.repository.CustomerOrderRepository;
import com.pedro.ordermanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerOrderRepository repository;
    @Autowired
    private ProductRepository productRepository;


    public List<CustomerOrderDTO> get(){
        return convertData(repository.findAll());
    }

    public void post(CreateCustomerOrderDTO dto) {
        List<Item> items = new ArrayList<>();

        for (ItemDTO itemDTO : dto.items()) {
            Product product = productRepository.findById(itemDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + itemDTO.productId()));

            Item item = new Item();
            item.setProduct(product);
            item.setQuantity(itemDTO.quantity());
            items.add(item);
        }

        CustomerOrder order = new CustomerOrder();
        for (Item item : items) {
            item.setOrder(order); // Vincula o pedido em cada item
        }
        order.setItems(items);
        order.setTotalItems();

        repository.save(order);
    }


    private List<CustomerOrderDTO> convertData(List<CustomerOrder> order) {
        return order.stream()
                .map(CustomerOrderDTO::new)
                .collect(Collectors.toList());
    }
}
