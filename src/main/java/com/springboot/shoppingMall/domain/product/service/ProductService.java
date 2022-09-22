package com.springboot.shoppingMall.domain.product.service;

import com.springboot.shoppingMall.domain.product.entity.Product;
import com.springboot.shoppingMall.domain.product.entity.ProductRepository;
import com.springboot.shoppingMall.dto.ProductSaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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

    public Long update(Long seq, ProductSaveDto dto){
        try{
            Product prod = productRepository.findAllById(seq);
            if(prod == null){
                throw new NullPointerException("상품이 존재하지 않습니다.");
            }
            prod.update(dto);
            return prod.getSeq();
        }catch (Exception e){
            log.error("product update error occur", e);
            return null;
        }
    }
}
