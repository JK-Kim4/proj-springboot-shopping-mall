package com.springboot.shoppingMall.domain.order.controller;

import com.springboot.shoppingMall.domain.order.dto.OrderProductDto;
import com.springboot.shoppingMall.domain.order.dto.OrderRequestDto;
import com.springboot.shoppingMall.domain.order.dto.OrderSummaryDto;
import com.springboot.shoppingMall.domain.order.service.OrderService;
import com.springboot.shoppingMall.domain.products.domain.Product;
import com.springboot.shoppingMall.domain.products.domain.ProductRepository;
import com.springboot.shoppingMall.domain.products.service.ProductService;
import com.springboot.shoppingMall.domain.user.domain.LoginUser;
import com.springboot.shoppingMall.domain.user.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final ProductService productService;
    private final OrderService orderService;
    private final ProductRepository productRepository;

    //주문 페이지
    @GetMapping("/order/{id}")
    public String orderPage(@PathVariable(value = "id") Long id,
                            Model model,
                            @LoginUser SessionUser user){
        model.addAttribute("product", productService.findItem(id));
        return "orders/order";
    }

    //바로 구매
    @PostMapping("/direct")
    public String direct(OrderRequestDto request, Model model){

        model.addAttribute("orderSummary", createOrderSummary(request));

        return "orders/order-summary";
    }

    public OrderSummaryDto createOrderSummary(OrderRequestDto request){

        Product product = productRepository.findById(request.getProductId()).get();

        OrderProductDto orderProductDto = new OrderProductDto(product.getId(),
                product.getName(),
                product.getPrice(),
                request.getOrderCount());

        return new OrderSummaryDto(Arrays.asList(orderProductDto));

    }

}
