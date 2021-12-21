package com.springboot.shoppingMall.domain.products.service;


import com.springboot.shoppingMall.domain.products.domain.*;
import com.springboot.shoppingMall.domain.products.dto.ProductDetails;
import com.springboot.shoppingMall.domain.products.dto.ProductListResponseDto;
import com.springboot.shoppingMall.domain.products.dto.ProductSaveReuestDto;
import com.springboot.shoppingMall.domain.products.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productsRepository;

    /*상품 등록*/
    @Transactional
    public Long save(ProductSaveReuestDto productSaveReuestDto){
        Product product = createProduct(productSaveReuestDto);
        Product saveProduct = productsRepository.save(product);

        return saveProduct.getId();
    }

    /*상품 수정*/
    @Transactional
    public Long update (Long id, ProductUpdateRequestDto productUpdateRequestDto){
        Product products = productsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        return id;
    }

    /*상품 조회*/
    @Transactional
    public List<ProductListResponseDto> findAllDesc(){
        return productsRepository.findAllDesc().stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }

    public ProductDetails findItem(Long productId){
        Product product = productsRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        return new ProductDetails(product);
    }


    private Product createProduct(ProductSaveReuestDto request){

        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .filePath(request.getFilePath())
                .stockQuantity(request.getStockQuantity())
                .build();

    }

}
