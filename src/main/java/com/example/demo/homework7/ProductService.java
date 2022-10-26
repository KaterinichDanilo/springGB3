package com.example.demo.homework7;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product findByTitle(String title) {
        return productRepository.findProductByTitle(title);
    }

    public void addProduct(String title, Integer price) {
        productRepository.save(new Product(title, price));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByPriceBefore(Integer max) {
        return productRepository.findAllByPriceBefore(max);
    }

    public List<Product> findAllByPriceAfter(Integer min) {
        return productRepository.findAllByPriceAfter(min);
    }

    public List<Product> findAllByPriceBetween(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min, max);
    }
}
