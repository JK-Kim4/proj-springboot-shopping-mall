package com.springboot.shoppingMall.domain.products.domain;


import com.springboot.shoppingMall.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String categoryName;

    @Builder
    public Category(String categoryName){
        this.categoryName = categoryName;
    }
}
