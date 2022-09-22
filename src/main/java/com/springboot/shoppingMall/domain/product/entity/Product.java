package com.springboot.shoppingMall.domain.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //Mysql
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //H2
    @Column(name = "PRODUCT_SEQ")
    private Long seq;

    @Column
    private String name; // 상품명

    @Column
    private String company; // 제조사

    @Column
    private int price; // 가격

    @Column
    private String content; // 상품 소개

    @Column
    private int stock; // 재고
}
