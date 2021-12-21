package com.springboot.shoppingMall.domain.order.controller;

import com.springboot.shoppingMall.domain.order.domain.Order;
import com.springboot.shoppingMall.domain.order.domain.OrderRepository;
import com.springboot.shoppingMall.domain.order.dto.OrderProductDto;
import com.springboot.shoppingMall.domain.order.dto.OrderRequestDto;
import com.springboot.shoppingMall.domain.order.dto.OrderSummaryDto;
import com.springboot.shoppingMall.domain.order.service.OrderService;
import com.springboot.shoppingMall.domain.products.domain.Product;
import com.springboot.shoppingMall.domain.products.domain.ProductRepository;
import com.springboot.shoppingMall.domain.products.service.ProductService;
import com.springboot.shoppingMall.domain.user.domain.LoginUser;
import com.springboot.shoppingMall.domain.user.domain.User;
import com.springboot.shoppingMall.domain.user.domain.UserRepository;
import com.springboot.shoppingMall.domain.user.dto.UserRequestDto;
import com.springboot.shoppingMall.domain.user.oauth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final ProductService productService;
    private final OrderService orderService;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    //주문 페이지
    @GetMapping("/order/{id}")
    public String orderPage(@PathVariable(value = "id") Long id,
                            Model model,
                            @LoginUser SessionUser user){
        model.addAttribute("product", productService.findItem(id));
        return "orders/order";
    }

    @PostMapping("/update/address")
    @ResponseBody
    public String updateAddress(@RequestBody UserRequestDto request){

        log.info("user Id for update : " + request.getUserId());

        User orderUser = userRepository.findById(request.getUserId()).get();
        orderUser.updateAddress(request.getAddress());
        orderUser = userRepository.save(orderUser);
        return orderUser.getAddress();
    }

    //바로 구매
    @PostMapping("/direct")
    public String direct(OrderRequestDto request, Model model, @LoginUser SessionUser user){

        /*TODO - 상품 주문 시 재고 수량 확인 필요 2021.12.21*/
        Long orderId =  orderService.save(request);
        Order order = orderRepository.findById(orderId).get();

        model.addAttribute("order", order);

        return "orders/order-complite";
    }

    //결제하기
    @PostMapping("/save")
    public Long save(OrderRequestDto request){
        return orderService.save(request);
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
