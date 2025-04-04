package com.pedro.ordermanager.model;

import com.pedro.ordermanager.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<CustomerOrder> orders = new ArrayList<>();

    public Product (ProductDTO productDTO){
        this.name = productDTO.name();
        this.price = productDTO.price();
        this.category = productDTO.category();
    }
}
