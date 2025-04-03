package com.pedro.ordermanager.repository;

import com.pedro.ordermanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameContainingIgnoreCase(String name);
    //Optional<List<Product>> findByCategory(String category);
    @Query("SELECT p FROM Product p Where p.name LIKE %:part%")
    Optional<List<Product>> findByPartOfTheName(String part);
}
