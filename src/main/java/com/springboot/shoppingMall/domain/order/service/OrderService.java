package com.springboot.shoppingMall.domain.order.service;

import com.springboot.shoppingMall.domain.order.domain.OrderRepository;
import com.springboot.shoppingMall.domain.order.dto.OrderRequestDto;
import com.springboot.shoppingMall.domain.products.domain.ProductRepository;
import com.springboot.shoppingMall.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Long save(OrderRequestDto request){

        return null;
    }

}
