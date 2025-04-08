package com.pedro.ordermanager.services;

import com.pedro.ordermanager.dto.ProductCreateDTO;
import com.pedro.ordermanager.dto.ProductDTO;
import com.pedro.ordermanager.dto.ProductUpdateDTO;
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

    public List<ProductDTO> get() {
        return convertDatas(Optional.of(repository.findAll()));
    }
    public Page<ProductDTO> getPage(Pageable pageable) {
        return repository.findAll(pageable).map(ProductDTO::new);
    }

    public List<ProductDTO> getTop5() {
        return convertDatas(repository.findTop5ByOrderByPriceDesc());
    }

    public void post(@Valid ProductCreateDTO productDTO) {
        repository.save(new Product(productDTO));
    }

    public void update(ProductUpdateDTO productDTO){
        var product = repository.getReferenceById(productDTO.id());
        product.updateProduct(productDTO);
    }

    private List<ProductDTO> convertDatas(Optional<List<Product>> products) {
        return products.map(productList -> productList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList())).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
