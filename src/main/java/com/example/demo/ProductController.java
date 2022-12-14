package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {
    ProductService productService;
    Basket basket;

    public ProductController(ProductService productService, Basket basket) {
        this.productService = productService;
        this.basket = basket;
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
    public ProductDto updateStudent(@RequestBody ProductDto product){
        return productService.update(product);
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

    @PatchMapping("/products/{id}/title")
    public void patchTitle(@PathVariable Long id, @RequestBody ProductDto productDto){
        productService.updateTitle(id, productDto);

    }

    @GetMapping("/products/basket")
    public void getBasket() {
        basket.getProducts();
    }

    @PostMapping("/products/add/{id}")
    public void addProductToBasket(@PathVariable(name = "id") Long id, @RequestBody ProductDto productDto) {
        basket.addProduct(productDto);
    }

    @DeleteMapping("/products/delete/{id}")
    public void deleteProductFromBasket(@PathVariable(name = "id") Long id, @RequestBody ProductDto productDto) {
        basket.deleteProduct(productDto);
    }
}
