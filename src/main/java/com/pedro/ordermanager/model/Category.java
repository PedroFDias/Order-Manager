package com.pedro.ordermanager.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;


public enum Category {
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    PET("Pet"),
    PC("Pc"),
    FOOD("Food"),
    TOYS("Toys");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}




//@Entity
//public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    @OneToMany(mappedBy = "category" , fetch = FetchType.EAGER)
//    private List<Product> products = new ArrayList<>();
//    private Integer productsSize;
//
//    public Category() {
//    }
//
//    public Category(String name)
//    {
//        this.name = name;
//        this.productsSize = 0;
//    }
//
//    public Integer getProductsSize() {
//        return products != null ? products.size() : 0;
//    }
//
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        products.forEach(p-> p.setCategory(this));
//        this.products = products;
//        this.productsSize = products != null ? products.size() : 0 ;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
