package com.springboot.shoppingMall.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ProductSaveDto {

    private String name; // 상품명
    private String company; // 제조사
    private int price; // 가격
    private String content; // 상품 소개
    private int stock; // 재고
}
