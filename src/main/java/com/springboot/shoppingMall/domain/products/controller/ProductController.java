package com.springboot.shoppingMall.domain.products.controller;

import com.springboot.shoppingMall.domain.products.dto.ProductDetails;
import com.springboot.shoppingMall.domain.products.dto.ProductListResponseDto;
import com.springboot.shoppingMall.domain.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/save")
    public String savePage(){
        return "products/products-save";
    }

    @GetMapping("/list")
    public String listPage(Model model){
        List<ProductListResponseDto> productList = productService.findAllDesc();
        model.addAttribute("products", productList);
        return "products/products-list";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable("id") Long id, Model model){

        log.info("detail id : " + id);
        ProductDetails product = productService.findItem(id);
        model.addAttribute("product", product);

        return "products/products-detail";
    }
}
