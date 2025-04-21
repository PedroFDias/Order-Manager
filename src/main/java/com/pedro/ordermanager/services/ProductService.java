package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.*;
import com.pedro.ordermanager.model.Product;
import com.pedro.ordermanager.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> get() {
        return convertData(Optional.of(repository.findAllByAvailableTrue()));
    }
    public ProductResponseDTO get(Long id) {
        return new ProductResponseDTO(repository.getReferenceById(id));
    }
    public Page<ProductResponseDTO> getPage(Pageable pageable) {
        return repository.findAllByAvailableTrue(pageable).map(ProductResponseDTO::new);
    }

    public List<ProductResponseDTO> getTop5() {
        return convertData(repository.findTop5ByOrderByPriceDesc());
    }

    public ProductResponseDTO post(@Valid ProductCreateDTO productDTO) {
        var response = repository.save(new Product(productDTO));
        return new ProductResponseDTO(response);
    }

    public ProductResponseDTO update(ProductUpdateDTO productDTO){
        var product = repository.getReferenceById(productDTO.id());
        product.updateProduct(productDTO);
        return new ProductResponseDTO(product);
    }

    private List<ProductResponseDTO> convertData(Optional<List<Product>> products) {
        return products.map(productList -> productList.stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList())).orElse(null);
    }

    public ProductResponseDTO delete(Long id) {
        var product = repository.getReferenceById(id);
        product.delete();
        return new ProductResponseDTO(product);
    }
}
