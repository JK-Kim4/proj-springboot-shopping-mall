package com.boiling.kidduramu.web.service;


import com.boiling.kidduramu.domain.products.Products;
import com.boiling.kidduramu.domain.products.ProductsRepository;
import com.boiling.kidduramu.web.dto.ProductListResponseDto;
import com.boiling.kidduramu.web.dto.ProductSaveReuestDto;
import com.boiling.kidduramu.web.dto.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductsRepository productsRepository;
    private final S3UploadService s3UploadService;

    /*상품 등록*/
    @Transactional
    public Long save(ProductSaveReuestDto productSaveDto, MultipartFile multipartFile){
        try{
            if(multipartFile != null){
                productSaveDto.setFileUrl(s3UploadService.upload(multipartFile));
            }
        }catch (Exception e){
            log.error("product save errpr : {}",e);
        }
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

    @Transactional
    public List<ProductListResponseDto> findAllDesc(){
        return productsRepository.findAllDesc().stream()
                .map(ProductListResponseDto::new)
                .collect(Collectors.toList());
    }

}
