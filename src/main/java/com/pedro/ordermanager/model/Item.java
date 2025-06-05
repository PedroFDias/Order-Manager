package com.pedro.ordermanager.model;

import com.pedro.ordermanager.dto.ItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;

    @ManyToOne
    private CustomerOrder order;

    public Item(ItemDTO item){
        this.product = new Product(); // precisa ser buscado do banco no real
        this.product.setId(item.productId());
        this.quantity = item.quantity();
    }
}
