package com.boiling.kidduramu.domain.products.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductSaveReuestDto {

    private String name;
    private String desc;
    private String seller;
    private String fileUrl;
    private int price;

    @Builder
    public ProductSaveReuestDto(String name, String desc,
                                String seller, String fileUrl,
                                int price){
        this.name = name;
        this.desc = desc;
        this.seller = seller;
        this.fileUrl = fileUrl;
        this.price = price;
    }

    public Products toEntity(){
        return Products.builder().
                name(name).
                desc(desc).
                seller(seller).
                fileUrl(fileUrl).
                price(price).
                build();
    }

}
