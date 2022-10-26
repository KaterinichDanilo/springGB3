package com.example.demo.homework7;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByTitle(String title);
    List<Product> findAllByPriceBefore(Integer max);
    List<Product> findAllByPriceAfter(Integer min);
    List<Product> findAllByPriceBetween(Integer min, Integer max);
}
