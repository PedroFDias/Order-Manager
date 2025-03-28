package com.pedro.ordermanager.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDate data;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_orders",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> products = new ArrayList<>();

    private  Integer productsSize;

    public CustomerOrder() {

        this.data = LocalDate.now();
    }

    public Long getId() {
        return id;
    }


    public Integer getProductsSize() {
        return products != null ? products.size() : 0;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setProducts(List<Product> products) {
        this.products.clear();
        products.forEach(this::addProduct);
    }

    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
            product.getOrders().add(this);
            this.productsSize = products != null ? products.size() : 0;
        }

    }

    public List<Product> getProducts() {
        return products;
    }
}
