package com.springboot.shoppingMall.domain.products.domain;

import com.springboot.shoppingMall.common.error.NotEnoughStockQuantityException;
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

    //가격
    @Column(nullable = false)
    private int price;

    //재고 수량
    @Column
    @ColumnDefault("0") //default 0
    private int stockQuantity;

    //카테고리
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Category> categoryList;

    //업로드 파일 S3 url
    @Column
    private String filePath;

    @Builder
    public Product(String name, int price, int stockQuantity, String filePath){
        this.filePath = filePath;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void removeStockQuantity(int orderQuantity){
        int restStockQuantity = this.stockQuantity - orderQuantity;

        if(restStockQuantity < 0)
            throw new NotEnoughStockQuantityException();

            this.stockQuantity = restStockQuantity;


    }

    public void addStockQuantity(int quantity){
        this.stockQuantity += quantity;
    }

    //상품 수정
    public void update(String name, String desc){
        this.name = name;
    }
}
