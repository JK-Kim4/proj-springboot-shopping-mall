package com.springboot.shoppingMall.domain.product.controller;

import com.springboot.shoppingMall.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
}
