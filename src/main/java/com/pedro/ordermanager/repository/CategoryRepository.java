package com.pedro.ordermanager.repository;

import com.pedro.ordermanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String pet);
}
