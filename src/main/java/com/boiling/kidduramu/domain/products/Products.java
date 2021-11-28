package com.boiling.kidduramu.domain.products;

import com.boiling.kidduramu.domain.BaseTimeEntity;
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
    private Long id;

    //상품명
    @Column(nullable = false)
    private String name;

    //상품설명
    @Column(nullable = false)
    private String desc;

    //판매자
    @Column(nullable = false)
    private String seller;

    //상품사진
    @Column
    private String picture;

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

    //조회수
    @Column
    @ColumnDefault("0") //default 0
    private int showCnt;

    @Builder
    public Products(String name, String desc,
                   String seller, String picture,
                   int stockCnt, int sellCnt,
                   int refundCnt, int showCnt){
        this.name = name;
        this.desc = desc;
        this.picture = picture;
        this.seller = seller;
        this.stockCnt = stockCnt;
        this.sellCnt = sellCnt;
        this.refundCnt = refundCnt;
        this.showCnt = showCnt;
    }
}
