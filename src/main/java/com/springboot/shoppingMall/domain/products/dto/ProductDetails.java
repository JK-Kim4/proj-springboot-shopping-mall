package com.springboot.shoppingMall.domain.products.dto;

import com.springboot.shoppingMall.domain.products.domain.Product;
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
    private int stockQuantity;

    public ProductDetails(Product entity){
        this.productId = entity.getId();
        this.name = entity.getName();
        this.filePath = entity.getFilePath();
        this.price = entity.getPrice();
        this.stockQuantity = entity.getStockQuantity();
    }


}
