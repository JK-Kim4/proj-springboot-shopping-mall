package com.springboot.shoppingMall.domain.products.domain;

import com.springboot.shoppingMall.domain.BaseTimeEntity;
import com.springboot.shoppingMall.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Products extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    //상품명
    @Column(nullable = false)
    private String name;

    //상품설명
    @Column(nullable = false)
    private String desc;

    //판매자
    @Column(nullable = false)
    private String seller;

    //판매자 ID
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(nullable = false)
    private int price;

    //업로드 파일 S3 url
    @Column
    private String fileUrl;

    //재고 수량
    @Column
    @ColumnDefault("0") //default 0
    private int stockCnt;

    //판매 수량
    @Column
    @ColumnDefault("0") //default 0
    private int sellCnt;

    //환불 수량
    @Column
    @ColumnDefault("0") //default 0
    private int refundCnt;

    @Builder
    public Products(String name, String desc,
                   String seller, String fileUrl,
                   int stockCnt, int sellCnt,
                   int refundCnt, int price){
        this.name = name;
        this.desc = desc;
        this.fileUrl = fileUrl;
        this.seller = seller;
        this.stockCnt = stockCnt;
        this.sellCnt = sellCnt;
        this.refundCnt = refundCnt;
        this.price = price;
    }

    //상품 수정
    public void update(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
}
