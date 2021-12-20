package com.springboot.shoppingMall.domain.order.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

    @Builder
    public Delivery(String address){
        this.address = address;
        this.status = DeliveryStatus.STAY;
    }

}
