package com.springboot.shoppingMall.domain.products.controller;

import com.springboot.shoppingMall.domain.products.domain.ProductSaveReuestDto;
import com.springboot.shoppingMall.domain.products.domain.ProductUpdateRequestDto;
import com.springboot.shoppingMall.domain.products.service.ProductService;
import com.springboot.shoppingMall.common.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;
    private final S3UploadService s3UploadService;

    @PostMapping("/api/product/insert")
    public String  save(ProductSaveReuestDto productSaveRequestDto,
                     @RequestPart(value = "uploadFile")MultipartFile file){

        Long id = productService.save(productSaveRequestDto);

        return "/product/detail/" +id;
    }

    @PutMapping("/api/product/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return productService.update(id, productUpdateRequestDto);
    }
}
