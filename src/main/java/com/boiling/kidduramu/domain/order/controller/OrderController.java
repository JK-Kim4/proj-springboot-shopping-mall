package com.boiling.kidduramu.domain.order.controller;

import com.boiling.kidduramu.domain.products.service.ProductService;
import com.boiling.kidduramu.domain.user.domain.LoginUser;
import com.boiling.kidduramu.domain.user.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final ProductService productService;

    //주문 페이지
    @GetMapping("/order/{id}")
    public String getOrder(Model model, @PathVariable(value = "id") Long id, @LoginUser SessionUser user){
        model.addAttribute("product", productService.findById(id));
        return "orders/order";
    }
}
