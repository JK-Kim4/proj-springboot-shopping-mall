package com.boiling.kidduramu.domain.order.domain;

import lombok.Getter;

//주문상태
@Getter
public enum OrderState {
    SECCESS("주문 성공"),
    CANCEL("주문 취소");

    private String status;

    OrderState(String state){
        this.status = state;
    }
}
