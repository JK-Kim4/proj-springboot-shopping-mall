package com.springboot.shoppingMall.domain.cart.domain;

import com.springboot.shoppingMall.domain.order.domain.DeliveryState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;

    @Column
    private String address;

    @Column
    @Enumerated(value = EnumType.STRING)
    private DeliveryState deliveryState;

    public Delivery (String address){
        this.address = address;
        this.deliveryState = DeliveryState.STAY;
    }

}
