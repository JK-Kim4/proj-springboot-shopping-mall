package com.boiling.kidduramu.web.dto;

import com.boiling.kidduramu.domain.products.Products;
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

    @Builder
    public ProductSaveReuestDto(String name, String desc,
                                String seller, String fileUrl){
        this.name = name;
        this.desc = desc;
        this.seller = seller;
        this.fileUrl = fileUrl;
    }

    public Products toEntity(){
        return Products.builder().
                name(name).
                desc(desc).
                seller(seller).
                fileUrl(fileUrl).
                build();
    }

}
