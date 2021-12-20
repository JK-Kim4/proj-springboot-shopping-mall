package com.springboot.shoppingMall.domain.products.domain;

import lombok.Getter;

@Getter
public class ProductListResponseDto {
    private Long productId;
    private String name;
    private String desc;
    private String seller;
    private String filePath;
    private int price;

    public ProductListResponseDto(Product entity){
        this.productId = entity.getProductId();
        this.name = entity.getName();
        this.desc = entity.getDesc();
        this.filePath = entity.getFilePath();
        this.price = entity.getPrice();
    }

}
