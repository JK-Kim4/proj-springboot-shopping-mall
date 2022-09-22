package com.springboot.shoppingMall.domain.product.entity;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import com.springboot.shoppingMall.dto.ProductSaveDto;
import lombok.Builder;
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
public class Product extends BaseTimeEntity {

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

    @Builder
    public Product(ProductSaveDto dto){
        this.name = dto.getName();
        this.company = dto.getCompany();
        this.price = dto.getPrice();
        this.content = dto.getContent();
        this.stock = 0;
    }

    public void update(ProductSaveDto dto){
        this.name = dto.getName();
        this.company = dto.getCompany();
        this.price = dto.getPrice();
        this.content = dto.getContent();
    }
}
