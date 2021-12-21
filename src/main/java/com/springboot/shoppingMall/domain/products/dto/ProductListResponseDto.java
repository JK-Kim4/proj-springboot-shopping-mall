package com.springboot.shoppingMall.domain.products.dto;

import com.springboot.shoppingMall.domain.products.domain.Product;
import lombok.Getter;

@Getter
public class ProductListResponseDto {
    private Long productId;
    private String name;
    private String filePath;
    private int price;

    public ProductListResponseDto(Product entity){
        this.productId = entity.getId();
        this.name = entity.getName();
        this.filePath = entity.getFilePath();
        this.price = entity.getPrice();
    }

}
