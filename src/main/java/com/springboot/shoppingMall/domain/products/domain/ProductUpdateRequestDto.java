package com.springboot.shoppingMall.domain.products.domain;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateRequestDto extends BaseTimeEntity {

    //상품명, 상품 설명 수정
    private String name;
    private String desc;

    @Builder
    public ProductUpdateRequestDto(String name,  String desc){
        this.name = name;
        this.desc = desc;
    }
}
