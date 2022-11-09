package com.example.demo.homework7;

public class ProductDto {
    private String title;

    private Integer price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ProductDto(Product product) {
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    public ProductDto() {
    }
}
