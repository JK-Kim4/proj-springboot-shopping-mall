package com.boiling.kidduramu.domain.order.controller;

import com.boiling.kidduramu.domain.order.dto.OrderRequestDto;
import com.boiling.kidduramu.domain.products.service.ProductService;
import com.boiling.kidduramu.domain.user.domain.LoginUser;
import com.boiling.kidduramu.domain.user.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final ProductService productService;

    //주문 페이
    @GetMapping("/")
    public String getOrder(Model model, @RequestBody OrderRequestDto orderRequestDto,
                           @LoginUser SessionUser user){
        model.addAttribute("product", productService.findById(orderRequestDto.getProductId()));
        return "orders/order";
    }
}
