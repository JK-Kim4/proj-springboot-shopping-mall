package com.springboot.shoppingMall.domain.order.domain;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import com.springboot.shoppingMall.domain.products.domain.Product;
import com.springboot.shoppingMall.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //구매인
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User orderUser;

    //구매상품
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product orderProduct;

    //주문 상태
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    //주문 수량
    @Column
    private int orderCount;


    @Builder
    public Order(User orderUser, Product orderProduct, int orderCount){
        this.orderUser = orderUser;
        this.orderProduct = orderProduct;
        this.status = OrderStatus.ORDERED;
        this.orderCount = orderCount;
    }

//    private int calcAmountPrice(){
//        return this.orderPrice = this.orderProduct.getPrice() * this.orderAmt;
//    }
}
