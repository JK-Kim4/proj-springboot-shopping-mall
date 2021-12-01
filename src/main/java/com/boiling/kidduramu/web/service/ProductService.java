package com.boiling.kidduramu.web.service;


import com.boiling.kidduramu.domain.products.Products;
import com.boiling.kidduramu.domain.products.ProductsRepository;
import com.boiling.kidduramu.web.dto.ProductSaveReuestDto;
import com.boiling.kidduramu.web.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    /*상품 등록*/
    @Transactional
    public Long save(ProductSaveReuestDto productSaveDto){
        return productsRepository.save(productSaveDto.toEntity()).getId();
    }

    /*상품 수정*/
    @Transactional
    public Long update (Long id, ProductUpdateRequestDto productUpdateRequestDto){
        Products products = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        products.update(productUpdateRequestDto.getName(), productUpdateRequestDto.getDesc());

        return id;
    }

}
