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

    //조회수
    @Column
    @ColumnDefault("0") //default 0
    private int showCnt;

    @Builder
    public Products(String name, String desc,
                   String seller, String fileUrl,
                   int stockCnt, int sellCnt,
                   int refundCnt, int showCnt){
        this.name = name;
        this.desc = desc;
        this.fileUrl = fileUrl;
        this.seller = seller;
        this.stockCnt = stockCnt;
        this.sellCnt = sellCnt;
        this.refundCnt = refundCnt;
        this.showCnt = showCnt;
    }

    //상품 수정
    public void update(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
}
