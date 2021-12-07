package com.boiling.kidduramu.web.controller;

import com.boiling.kidduramu.web.dto.ProductSaveReuestDto;
import com.boiling.kidduramu.web.dto.ProductUpdateRequestDto;
import com.boiling.kidduramu.web.service.ProductService;
import com.boiling.kidduramu.web.service.S3UploadService;
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
    public Long save(ProductSaveReuestDto productSaveRequestDto,
                     @RequestPart(value = "uploadFile")MultipartFile file){

        log.info("request dto : {}", productSaveRequestDto.toString());
        log.info("request file : {}", file.getOriginalFilename());

        return productService.save(productSaveRequestDto, file);
    }

    @PutMapping("/api/product/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return productService.update(id, productUpdateRequestDto);
    }
}
