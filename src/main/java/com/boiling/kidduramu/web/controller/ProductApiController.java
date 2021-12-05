package com.boiling.kidduramu.web.controller;

import com.boiling.kidduramu.web.dto.ProductSaveReuestDto;
import com.boiling.kidduramu.web.dto.ProductUpdateRequestDto;
import com.boiling.kidduramu.web.service.FileService;
import com.boiling.kidduramu.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;
    private final FileService fileService;

    @PostMapping("/api/product/insert")
    public Long save(@RequestBody ProductSaveReuestDto productSaveRequestDto){
        return productService.save(productSaveRequestDto);
    }

    @PutMapping("/api/product/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return productService.update(id, productUpdateRequestDto);
    }
}
