package com.springboot.shoppingMall.domain.product.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findAllById(Long seq);

}
