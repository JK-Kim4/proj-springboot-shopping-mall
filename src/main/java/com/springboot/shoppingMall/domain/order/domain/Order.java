package com.springboot.shoppingMall.domain.order.domain;

import com.springboot.shoppingMall.domain.products.domain.Products;
import com.springboot.shoppingMall.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderProductId;

    //주문 수량
    @Column
    private int orderCnt;

    //결제 금액
    @Column
    private int orderProductAmount;

    //주문상태
    @Column
    private OrderStatus orderstatus;

    //구매인
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    //구매상품
    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Products orderProduct;

    @Builder
    public Order(Products products, int orderCnt){
        this.orderCnt = orderCnt;
        this.orderProduct = products;
        this.calcAmountPrice();
    }

    private int calcAmountPrice(){
        return this.orderProductAmount = this.orderProduct.getPrice() * this.orderCnt;
    }
}
