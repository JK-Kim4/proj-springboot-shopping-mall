package com.springboot.shoppingMall.domain.products.domain;

import lombok.Getter;

@Getter
public class ProductListResponseDto {
    private Long id;
    private String name;
    private String desc;
    private String seller;
    private String fileUrl;
    private int price;

    public ProductListResponseDto(Products entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.desc = entity.getDesc();
        this.seller = entity.getSeller();
        this.fileUrl = entity.getFileUrl();
        this.price = entity.getPrice();
    }

}
