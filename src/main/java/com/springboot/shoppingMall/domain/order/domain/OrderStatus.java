package com.springboot.shoppingMall.domain.order.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {

    ORDERED("주문 완료"),
    CANCEL("주문 취소");

    private String status;

    OrderStatus(String status){
        this.status = status;
    }

}
