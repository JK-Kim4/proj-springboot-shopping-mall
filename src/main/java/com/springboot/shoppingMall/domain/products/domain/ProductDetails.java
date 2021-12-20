package com.springboot.shoppingMall.domain.products.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductDetails {

    private Long productId;
    private String name;
    private String filePath;
    private int price;

    public ProductDetails(Product entity){
        this.productId = entity.getId();
        this.name = entity.getName();
        this.filePath = entity.getFilePath();
        this.price = entity.getPrice();
    }


}
