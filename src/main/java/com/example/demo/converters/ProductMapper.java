package com.example.demo.converters;

import com.example.demo.Product;
import com.example.demo.ProductDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
//    @Mapping(source = "name1", target = "name2")
    Product toProduct(ProductDto productDto);

    @InheritInverseConfiguration
    ProductDto fromProduct(Product product);
}
