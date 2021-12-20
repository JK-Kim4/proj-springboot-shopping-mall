package com.springboot.shoppingMall.domain.order.domain;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import com.springboot.shoppingMall.domain.products.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
@Getter
@NoArgsConstructor
public class OrderProduct extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderProductId;
    private int orderQuentity;
    private int orderAmount;


    //주문 상품
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public OrderProduct(Product product, int orderQuentity){
        this.order(product, orderQuentity);
        this.orderQuentity = orderQuentity;
        this.calculateOrderProductTotalAmount();
    }

    public void order(Product product, int orderQuentity){
        product.removeStockQuentity(orderQuentity);
        this.product = product;
    }

    public void calculateOrderProductTotalAmount(){
        this.orderAmount = this.product.getPrice() * orderQuentity;
    }

    public void cancel(){
        this.product.addStockQuentity(this.orderQuentity);
    }

}
