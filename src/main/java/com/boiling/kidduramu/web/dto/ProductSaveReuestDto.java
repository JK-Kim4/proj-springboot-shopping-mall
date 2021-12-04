package com.boiling.kidduramu.web.dto;

import com.boiling.kidduramu.domain.products.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductSaveReuestDto {

    private String name;
    private String desc;
    private String seller;
    private Long fileId;

    @Builder
    public ProductSaveReuestDto(String name, String desc,
                                String seller, Long fileId){
        this.name = name;
        this.desc = desc;
        this.seller = seller;
        this.fileId = fileId;
    }

    public Products toEntity(){
        return Products.builder().
                name(name).
                desc(desc).
                seller(seller).
                fileId(fileId).
                build();
    }

}
