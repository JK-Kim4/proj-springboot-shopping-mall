package com.springboot.shoppingMall.domain.order.domain;

import com.springboot.shoppingMall.domain.products.domain.Products;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderProductId;

    //주문 수량
    @Column
    private int orderCnt;

    //결제 금액
    @Column
    private int orderProductAmount;

//    @Column
//    private OrderStatus orderstatus;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Products orderProduct;

    @Builder
    public OrderProduct(Products products, int orderCnt){
        this.orderCnt = orderCnt;
        this.orderProduct = products;
        this.calcAmountPrice();
    }

    private int calcAmountPrice(){
        return this.orderProductAmount = this.orderProduct.getPrice() * this.orderCnt;
    }
}
