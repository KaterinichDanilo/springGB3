package com.example.demo.homework7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable(name = "id") Long id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestParam(name = "title") String title, @RequestParam(name = "price") Integer price) {
        productService.addProduct(title, price);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
    }

    @GetMapping("/products/min/{minprice}")
    public List<Product> getProductByPriceAfter(@PathVariable(name = "minprice") Integer minPrice) {
        return productService.findAllByPriceAfter(minPrice);
    }

    @GetMapping("/products/max/{maxprice}")
    public List<Product> getProductByPriceBefore(@PathVariable(name = "maxprice") Integer maxPrice) {
        return productService.findAllByPriceBefore(maxPrice);
    }

    @GetMapping("/products/between")
    public List<Product> getProductByPriceBefore(@RequestParam(name = "minprice") Integer minPrice,
                                                 @RequestParam(name = "maxprice") Integer maxPrice) {
        return productService.findAllByPriceBetween(minPrice, maxPrice);
    }
}
