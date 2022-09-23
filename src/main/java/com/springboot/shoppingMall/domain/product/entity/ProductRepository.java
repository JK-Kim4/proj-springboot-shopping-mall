package com.springboot.shoppingMall.domain.product.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query( "UPDATE Product p " +
            "SET p.name =:name, p.company=:company, " +
                "p.content=:content, p.price=:price  " +
            "WHERE p.seq=:seq")
    int updateProduct(@Param(value="name") String name, @Param(value = "company") String company,
                   @Param(value="content") String content, @Param(value = "price") int price,
                   @Param(value="seq") Long seq);

    @Transactional
    @Modifying
    @Query( "UPDATE Product p " +
            "SET p.name =:#{#dto.name}, p.company=:#{#dto.company}, " +
            "p.content=:#{#dto.company}, p.price=:#{#dto.price}  " +
            "WHERE p.seq=:seq")
    int updateProduct(@Param(value = "dto")Product dto, @Param(value = "seq") Long seq);

}
