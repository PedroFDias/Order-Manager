package com.pedro.ordermanager.model;

import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.dto.ProductUpdateDTO;
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

//    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
//    private List<CustomerOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Item> items;

    public Product (ProductDTO productDTO){
        this.name = productDTO.name();
        this.price = productDTO.price();
        this.category = productDTO.category();
    }
    public void updateProduct(ProductUpdateDTO data){
        if(data.name() != null)
            this.name = data.name();
        if(data.price() != null)
            this.price = data.price();
        if(data.category() != null)
            this.category = data.category();

    }
}
