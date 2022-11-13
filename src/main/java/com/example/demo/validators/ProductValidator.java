package com.example.demo.validators;

import com.example.demo.ProductDto;
import com.example.demo.exceptions.ValidateException;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {
    public void validate(ProductDto productDto){
        List<String> errors = new ArrayList<String>();
        if (productDto.getPrice() < 0){
            errors.add("Price can't be less then 0");
        }
        if (productDto.getTitle().isBlank()){
            errors.add("Title can't be empty");
        }

        if (!errors.isEmpty()){
            throw new ValidateException(errors);
        }
    }
}
