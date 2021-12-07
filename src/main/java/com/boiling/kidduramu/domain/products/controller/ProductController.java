package com.boiling.kidduramu.domain.products.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("products")
public class ProductController {

    @GetMapping("/save")
    public String savePage(){
        return "products/products-save";
    }
}
