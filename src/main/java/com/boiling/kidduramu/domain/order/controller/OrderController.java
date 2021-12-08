package com.boiling.kidduramu.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    @GetMapping("/")
    public String getOrder(){
        return "orders/order";
    }
}
