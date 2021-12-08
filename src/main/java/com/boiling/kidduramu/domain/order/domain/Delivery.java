package com.boiling.kidduramu.domain.order.domain;

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
    }

}
