package com.springboot.shoppingMall.domain.product.controller;

import com.springboot.shoppingMall.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;
}
