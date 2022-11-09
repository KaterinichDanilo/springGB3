package com.example.demo.homework7;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAll() {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAll().forEach(p -> productDto.add(new ProductDto(p)));
        return productDto;
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(p -> new ProductDto(p)).orElseThrow();
    }

    public Product findByTitle(String title) {
        return productRepository.findProductByTitle(title);
    }

    public void addProduct(String title, Integer price) {
        productRepository.save(new Product(title, price));
    }
    public ProductDto addProduct(Product product) {
        return new ProductDto(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDto> findAllByPriceBefore(Integer max) {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAllByPriceBefore(max).forEach(p -> productDto.add(new ProductDto(p)));
        return productDto;
    }

    public List<ProductDto> findAllByPriceAfter(Integer min) {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAllByPriceAfter(min).forEach(p -> productDto.add(new ProductDto(p)));
        return productDto;
    }

    public List<ProductDto> findAllByPriceBetween(Integer min, Integer max) {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAllByPriceBetween(min, max).forEach(p -> productDto.add(new ProductDto(p)));
        return productDto;
    }
}
