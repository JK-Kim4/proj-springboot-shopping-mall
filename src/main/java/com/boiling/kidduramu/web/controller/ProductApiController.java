package com.boiling.kidduramu.web.controller;

import com.boiling.kidduramu.web.dto.ProductSaveReuestDto;
import com.boiling.kidduramu.web.dto.ProductUpdateRequestDto;
import com.boiling.kidduramu.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("/api/product/insert")
    public Long save(@RequestBody ProductSaveReuestDto productSaveRequestDto){
        return productService.save(productSaveRequestDto);
    }

    @PutMapping("/api/product/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return productService.update(id, productUpdateRequestDto);
    }
}
