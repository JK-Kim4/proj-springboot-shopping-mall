package com.boiling.kidduramu.web.service;


import com.boiling.kidduramu.domain.products.ProductsRepository;
import com.boiling.kidduramu.web.dto.ProductSaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    /*상품등록*/
    @Transactional
    public Long save(ProductSaveDto productSaveDto){
        return productsRepository.save(productSaveDto.toEntity()).getId();
    }

}
