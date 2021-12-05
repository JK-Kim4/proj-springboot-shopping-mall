package com.boiling.kidduramu.web.dto;

import com.boiling.kidduramu.domain.products.Products;
import lombok.Getter;

@Getter
public class ProductListResponseDto {
    private Long id;
    private String name;
    private String desc;
    private String seller;

    public ProductListResponseDto(Products entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.desc = entity.getDesc();
        this.seller = entity.getSeller();
    }

}
