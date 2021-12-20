package com.springboot.shoppingMall.domain.products.domain;

import lombok.Getter;

@Getter
public class ProductListResponseDto {
    private Long productId;
    private String name;
    private String desc;
    private String seller;
    private String fileUrl;
    private int price;

    public ProductListResponseDto(Products entity){
        this.productId = entity.getProductId();
        this.name = entity.getName();
        this.desc = entity.getDesc();
        this.seller = entity.getSeller();
        this.fileUrl = entity.getFileUrl();
        this.price = entity.getPrice();
    }

}
