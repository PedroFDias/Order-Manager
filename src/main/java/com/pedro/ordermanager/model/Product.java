package com.pedro.ordermanager.model;

import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @ManyToMany(mappedBy = "products" , fetch = FetchType.EAGER)
    private List<CustomerOrder> orders = new ArrayList<>();

    public Product() {
    }
    public Product(String name, Double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(CustomerOrder orders) {
        this.orders.add(orders);
    }
}
