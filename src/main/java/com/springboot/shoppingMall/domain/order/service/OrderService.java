package com.springboot.shoppingMall.domain.order.service;

import com.springboot.shoppingMall.domain.order.domain.Order;
import com.springboot.shoppingMall.domain.order.domain.OrderRepository;
import com.springboot.shoppingMall.domain.order.dto.OrderRequestDto;
import com.springboot.shoppingMall.domain.products.domain.Product;
import com.springboot.shoppingMall.domain.products.domain.ProductRepository;
import com.springboot.shoppingMall.domain.user.domain.User;
import com.springboot.shoppingMall.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(OrderRequestDto request){

        try{
            //구매자 정보 조회 및 주소 업데이트
            User user = userRepository.findById(request.getUserId()).get();
            user.updateAddress(request.getAddress());
            userRepository.save(user);

            //주문 상품 정보
            Product product = productRepository.findById(request.getProductId()).get();

            Order saveOrder = createOrder(user, product, request.getOrderCount());

            Order result = orderRepository.save(saveOrder);

            List<Order> list = orderRepository.findAll();

            log.info("list size : " + list.size());

            log.info("order insert result : " + result.getOrderUser() + ", " + result.getId());

            return result.getId();
        }catch (Exception e){
            log.error("save error : " + e);

            return null;
        }

    }


    public Order createOrder(User user, Product product, int orderCount){
        return Order.builder()
                .orderUser(user)
                .orderProduct(product)
                .orderCount(orderCount)
                .build();
    }

}
