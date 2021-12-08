package com.boiling.kidduramu.domain.order.domain;

import lombok.Getter;

@Getter
public enum DeliveryState {
    STAY("배송 대기"),
    ING("배송중 "),
    COMPLETE("배송 완료");

    private String state;

    DeliveryState(String state){
        this.state = state;
    }

}
