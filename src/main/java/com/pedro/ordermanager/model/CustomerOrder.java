package com.pedro.ordermanager.model;

import com.pedro.ordermanager.dto.CustomerOrderDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDate data;

    private  Integer productsSize;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;

    public CustomerOrder(@Valid CustomerOrderDTO orderDTO){
        this.data = orderDTO.data();
        this.productsSize = orderDTO.sizeItems();
    }
}
