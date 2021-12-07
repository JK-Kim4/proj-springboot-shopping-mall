package com.boiling.kidduramu.domain.products.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query("SELECT p FROM Products p ORDER BY p.id DESC")
    List<Products> findAllDesc();
}
