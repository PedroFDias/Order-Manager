package com.pedro.ordermanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
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

//    public CustomerOrder(CreateCustomerOrderDTO orderDTO){
//        this.productsSize = orderDTO.;
//    }
}
