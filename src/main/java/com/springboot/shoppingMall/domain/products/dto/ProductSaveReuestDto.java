package com.springboot.shoppingMall.domain.products.dto;

import com.springboot.shoppingMall.domain.products.domain.Product;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductSaveReuestDto {

    private String name;
    private int stockQuantity;
    private int categoryId;
    private String seller;
    private String filePath;
    private int price;

    @Builder
    public ProductSaveReuestDto(String name, String seller, String filePath,
                                int price, int categoryId){
        this.name = name;
        this.seller = seller;
        this.filePath = filePath;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Product toEntity(){
        return Product.builder().
                name(name).
                filePath(filePath).
                price(price).
                stockQuantity(stockQuantity).
                build();
    }

}
