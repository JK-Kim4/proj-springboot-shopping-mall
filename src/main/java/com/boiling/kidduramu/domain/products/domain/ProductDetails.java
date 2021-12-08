package com.boiling.kidduramu.domain.products.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductDetails {

    private Long productId;
    private String name;
    private String desc;
    private String fileUrl;
    private String seller;
    private int price;

    public ProductDetails(Products entity){
        this.productId = entity.getId();
        this.name = entity.getName();
        this.desc = entity.getDesc();
        this.fileUrl = entity.getFileUrl();
        this.seller = entity.getSeller();
        this.price = entity.getPrice();
    }


}
