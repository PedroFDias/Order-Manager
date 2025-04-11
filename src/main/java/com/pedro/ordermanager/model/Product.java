package com.pedro.ordermanager.model;

import com.pedro.ordermanager.dto.ProductCreateDTO;
import com.pedro.ordermanager.dto.ProductUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    private Boolean available = true;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Item> items;

    public Product(@Valid ProductCreateDTO productDTO) {
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

    public void delete() {
        this.available = false;
    }
}
