package com.boiling.kidduramu.web.dto;

import com.boiling.kidduramu.domain.products.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveReuestDto {

    private String name;
    private String desc;
    private String seller;
    private String picture;

    @Builder
    public ProductSaveReuestDto(String name, String desc,
                                String seller, String picture){
        this.name = name;
        this.desc = desc;
        this.seller = seller;
        this.picture = picture;
    }

    public Products toEntity(){
        return Products.builder().
                name(name).
                desc(desc).
                seller(seller).
                picture(picture).
                build();
    }

}
