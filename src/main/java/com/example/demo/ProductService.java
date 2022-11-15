package com.example.demo;

import com.example.demo.converters.ProductConverter;
import com.example.demo.exceptions.ValidateException;
import com.example.demo.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private ProductRepository productRepository;
    private ProductConverter productConverter;
    private ProductValidator productValidator;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAll() {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAll().forEach(p -> productDto.add(new ProductDto(p.getId(), p.getTitle(), p.getPrice())));
        return productDto;
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(p -> productConverter.entityToDto(p)).orElseThrow();
    }

    public Product findByTitle(String title) {
        return productRepository.findProductByTitle(title);
    }

    public void addProduct(String title, Integer price) {
        productRepository.save(new Product(title, price));
    }
    public ProductDto addProduct(ProductDto product) {
        productValidator.validate(product);
        productRepository.save(productConverter.dtoToEntity(product));
        return product;
    }

    public void delete(Long id) {
//        log.info("Product id={} was deleted", id);
        productRepository.deleteById(id);
    }

    public List<ProductDto> findAllByPriceBefore(Integer max) {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAllByPriceBefore(max).forEach(p -> productDto.add(productConverter.entityToDto(p)));
        return productDto;
    }

    public List<ProductDto> findAllByPriceAfter(Integer min) {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAllByPriceAfter(min).forEach(p -> productDto.add(productConverter.entityToDto(p)));
        return productDto;
    }

    public List<ProductDto> findAllByPriceBetween(Integer min, Integer max) {
        List<ProductDto> productDto = new ArrayList<>();
        productRepository.findAllByPriceBetween(min, max).forEach(p -> productDto.add(productConverter.entityToDto(p)));
        return productDto;
    }

    @Transactional
    public ProductDto update(ProductDto productDto) {
        if (productRepository.existsById(productDto.getId())){
            throw new ValidateException(List.of("Product with that id doesn't exists"));
        }

        Product product = productRepository.findProductById(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        return productDto;
    }

    @Transactional
    public void updateTitle(Long id, ProductDto productDto) {
        Product product = productRepository.findProductById(productDto.getId());
        product.setTitle(productDto.getTitle());
    }
}
