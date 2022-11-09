package com.example.demo.homework7;

import com.example.demo.lesson7.data.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDto> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable(name = "id") Long id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestParam(name = "title") String title, @RequestParam(name = "price") Integer price) {
        productService.addProduct(title, price);
    }

    @DeleteMapping("/{id}")
    public void deleteProductByID(@PathVariable(name = "id") Long id) {
        productService.delete(id);
    }

    @PutMapping
    public ProductDto updateStudent(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/products/min/{minprice}")
    public List<ProductDto> getProductByPriceAfter(@PathVariable(name = "minprice") Integer minPrice) {
        return productService.findAllByPriceAfter(minPrice);
    }

    @GetMapping("/products/max/{maxprice}")
    public List<ProductDto> getProductByPriceBefore(@PathVariable(name = "maxprice") Integer maxPrice) {
        return productService.findAllByPriceBefore(maxPrice);
    }

    @GetMapping("/products/between")
    public List<ProductDto> getProductByPriceBefore(@RequestParam(name = "minprice") Integer minPrice,
                                                 @RequestParam(name = "maxprice") Integer maxPrice) {
        return productService.findAllByPriceBetween(minPrice, maxPrice);
    }
}
