package com.example.demo.converters;

import com.example.demo.Product;
import com.example.demo.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto dto){
        return new Product(dto.getTitle(), dto.getPrice());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
