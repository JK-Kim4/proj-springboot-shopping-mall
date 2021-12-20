package com.springboot.shoppingMall.domain.order.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderSummaryDto {

    private List<OrderProductDto> orderProductList;
    private int totalAmount;

    public OrderSummaryDto(List<OrderProductDto> orderProductList) {
        this.orderProductList = orderProductList;
        this.totalAmount = orderProductList.stream()
                .mapToInt(orderItem -> orderItem.getTotalAmount())
                .sum();
    }

}
