package com.pedro.ordermanager.repository;

import com.pedro.ordermanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
