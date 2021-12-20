package com.springboot.shoppingMall.domain.products.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductSaveReuestDto {

    private String name;
    private String desc;
    private int stockQuentity;
    private int categoryId;
    private String seller;
    private String filaPath;
    private int price;

    @Builder
    public ProductSaveReuestDto(String name, String desc,
                                String seller, String filaPath,
                                int price, int categoryId){
        this.name = name;
        this.desc = desc;
        this.seller = seller;
        this.filaPath = filaPath;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Product toEntity(){
        return Product.builder().
                name(name).
                filePath(filaPath).
                price(price).
                stockQuentity(stockQuentity).
                build();
    }

}
