package com.pedro.ordermanager;

import com.pedro.ordermanager.main.Main;
import com.pedro.ordermanager.repository.CategoryRepository;
import com.pedro.ordermanager.repository.CustomerOrderRepository;
import com.pedro.ordermanager.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerApplication.class, args);
	}

	@Autowired
	private CategoryRepository repositoryCategory;
	@Autowired
	private ProductRepository repositoryProduct;
	@Autowired
	private CustomerOrderRepository repositoryCustomerOrder;

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.run(repositoryCategory, repositoryCustomerOrder, repositoryProduct);
	}
}
