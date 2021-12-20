package com.springboot.shoppingMall.domain.order.domain;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import com.springboot.shoppingMall.domain.products.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class OrderProduct extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int orderQuantity;
    private int orderAmount;


    //주문 상품
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public OrderProduct(Product product, int orderQuantity){
        this.order(product, orderQuantity);
        this.orderQuantity = orderQuantity;
        this.calculateOrderProductTotalAmount();
    }

    public void order(Product product, int orderQuantity){
        product.removeStockQuantity(orderQuantity);
        this.product = product;
    }

    public void calculateOrderProductTotalAmount(){
        this.orderAmount = this.product.getPrice() * orderQuantity;
    }

    public void cancel(){
        this.product.addStockQuantity(this.orderQuantity);
    }

}
