package com.springboot.shoppingMall.domain.product.service;

import com.springboot.shoppingMall.domain.product.entity.Product;
import com.springboot.shoppingMall.domain.product.entity.ProductRepository;
import com.springboot.shoppingMall.dto.ProductSaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Long save(ProductSaveDto dto){
        try{
            Product request = new Product(dto);
            return productRepository.save(request).getSeq();
        }catch (Exception e){
            log.error("Product save Error occur", e);
            return null;
        }
    }


    public int update(Long seq, ProductSaveDto dto){
        int result = 0;
        try{
            Product prod = productRepository.getOne(seq);
            if(prod == null){
                throw new NullPointerException("상품이 존재하지 않습니다.");
            }else{
                result = productRepository.updateProduct(prod, prod.getSeq());
            }
            return result;
        }catch (Exception e){
            log.error("product update error occur", e);
            return result;
        }
    }
}
