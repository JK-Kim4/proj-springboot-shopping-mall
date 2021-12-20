package com.springboot.shoppingMall.domain.order.domain;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import com.springboot.shoppingMall.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    //구매인
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User orderUser;

    //구매상품
    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private List<OrderProduct> orderProductList;

    //주문 상태
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    //주문 수량
    @Column
    private int orderAmt;

    //결제 금액
    @Column
    private int orderPrice;

    //주문상태
//    @Column
//    private OrderStatus orderstatus;

    @Builder
    public Order(User orderUser, OrderProduct... orderProductList){
        this.orderUser = orderUser;
        this.setOrderProductList(orderProductList);
        this.status = OrderStatus.ORDERED;
    }

    private void setOrderProductList(OrderProduct... orderProductList){
        Arrays.stream(orderProductList)
                .forEach(orderProduct -> this.orderProductList.add(orderProduct));
        this.calculateTotalAmount();
    }

    private void calculateTotalAmount(){
        this.orderAmt = this.orderProductList.stream()
                .mapToInt(orderProduct -> orderProduct.getOrderAmount())
                .sum();
    }

//    private int calcAmountPrice(){
//        return this.orderPrice = this.orderProduct.getPrice() * this.orderAmt;
//    }
}
