package com.springboot.shoppingMall.domain.products.domain;

import com.springboot.shoppingMall.common.error.NotEnoughStockQuentityException;
import com.springboot.shoppingMall.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    //상품명
    @Column(nullable = false)
    private String name;

    //상품설명
    @Column(nullable = false)
    private String desc;

    //가격
    @Column(nullable = false)
    private int price;

    //재고 수량
    @Column
    @ColumnDefault("0") //default 0
    private int stockQuentity;

    //카테고리
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Category> categoryList;

    //업로드 파일 S3 url
    @Column
    private String filePath;

    @Builder
    public Product(String name, int price, int stockQuentity, String filePath){
        this.filePath = filePath;
        this.name = name;
        this.price = price;
        this.stockQuentity = stockQuentity;
    }

    public void removeStockQuentity(int orderQuentity){
        int restStockQuentity = this.stockQuentity - orderQuentity;

        if(restStockQuentity < 0)
            throw new NotEnoughStockQuentityException();

            this.stockQuentity = restStockQuentity;


    }

    public void addStockQuentity(int quantity){
        this.stockQuentity += quantity;
    }

    //상품 수정
    public void update(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
}
