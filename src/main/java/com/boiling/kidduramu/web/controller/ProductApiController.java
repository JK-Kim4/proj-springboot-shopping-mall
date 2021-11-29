package com.boiling.kidduramu.web.controller;

import com.boiling.kidduramu.web.dto.ProductSaveDto;
import com.boiling.kidduramu.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("/api/product/insert")
    public Long save(@RequestBody ProductSaveDto productSaveDto){
        return productService.save(productSaveDto);
    }
}
