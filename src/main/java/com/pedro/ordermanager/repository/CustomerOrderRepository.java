package com.pedro.ordermanager.repository;

import com.pedro.ordermanager.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
