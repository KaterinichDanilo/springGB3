package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Scope("singleton")
public class Basket {
    private Map<ProductDto, Integer> products = new HashMap();

    public void addProduct(ProductDto productDto){
        if (this.products.keySet().contains(productDto)){
            products.put(productDto, (int)products.get(productDto) + 1);
            return;
        }
        products.put(productDto, 1);
    }

    public void deleteProduct(ProductDto productDto){
        if (this.products.keySet().contains(productDto)){
            if ((int)products.get(productDto) > 1){
                products.put(productDto, (int)products.get(productDto) - 1);
                return;
            }
            Map products2 = new HashMap<ProductDto, Integer>();
            for (ProductDto product : products.keySet()) {
                if (!product.equals(productDto)){
                    products2.put(product, products.get(product));
                }
            }
            products = products2;
        }
    }

    public Basket() {
        this.products = new HashMap<>();
    }

    public Map getProducts() {
        return products;
    }

    public void setProducts(Map products) {
        this.products = products;
    }
}
