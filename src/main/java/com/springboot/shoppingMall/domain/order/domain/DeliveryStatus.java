package com.springboot.shoppingMall.domain.order.domain;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
    STAY("배송 대기"),
    ING("배송중 "),
    COMPLETE("배송 완료");

    private String state;

    DeliveryStatus(String state){
        this.state = state;
    }

}
