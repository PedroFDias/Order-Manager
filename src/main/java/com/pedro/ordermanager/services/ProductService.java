package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> getProducts() {
        return convertDatas(Optional.of(repository.findAll()));
    }

    public List<ProductDTO> getTop5MoreExpensive() {
        return convertDatas(repository.findTop5ByOrderByPriceDesc());
    }

    public void postProducts(ProductDTO productDTO) {
        repository.save(new Product(productDTO));
    }


    private List<ProductDTO> convertDatas(Optional<List<Product>> products) {
        return products.map(productList -> productList.stream()
                .map(p -> new ProductDTO( p.getName(), p.getPrice(), p.getCategory()))
                .collect(Collectors.toList())).orElse(null);
    }
}
