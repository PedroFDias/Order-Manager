package com.pedro.ordermanager.model;

import com.pedro.ordermanager.dto.CustomerOrderUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class) // used for @CreateDate word(funcione)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDate date;

    private  Integer totalItems;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();;

    public void setTotalItems(){
        this.totalItems = items.stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public void updateOrder(@Valid CustomerOrderUpdateDTO data, List<Item> updatedItems) {
        if (data.date() != null)
            this.date = data.date();

        this.items.clear();

        for (Item item : updatedItems) {
            item.setOrder(this);
            this.items.add(item);
        }
        setTotalItems();
    }

}
