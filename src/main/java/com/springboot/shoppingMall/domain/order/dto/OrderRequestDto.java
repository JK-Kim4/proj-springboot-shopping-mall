package com.springboot.shoppingMall.domain.order.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDto {

    private Long userId;
    private Long productId;
    private int orderCount;
    private String address;

    @Builder
    public OrderRequestDto(Long userId, Long productId,
                           int orderCount, String address){
        this.userId = userId;
        this.productId = productId;
        this.orderCount = orderCount;
        this.address = address;

    }

}
