package com.pedro.ordermanager.repository;

import com.pedro.ordermanager.model.CustomerOrder;
import com.pedro.ordermanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.name = :name")
    Product findByName(String name);

}
