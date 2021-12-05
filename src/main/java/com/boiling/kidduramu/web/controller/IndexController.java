package com.boiling.kidduramu.web.controller;

import com.boiling.kidduramu.domain.user.LoginUser;
import com.boiling.kidduramu.domain.user.Role;
import com.boiling.kidduramu.oauth.dto.SessionUser;
import com.boiling.kidduramu.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        log.warn("index page");
        if(user != null && user.getRole() == Role.SELLER){
            log.warn("session name : " + user.getName());
            log.warn("session role : " + user.getRole());
            model.addAttribute("seller", true);
        }
        if(!productService.findAllDesc().isEmpty()){
            log.warn("Product List : " + productService.findAllDesc().get(0).getName());
        }
//        if(user.getRole() == Role.SELLER){
//            model.addAttribute("seller", user.getRole());
//        }
        return "index";
    }

}
