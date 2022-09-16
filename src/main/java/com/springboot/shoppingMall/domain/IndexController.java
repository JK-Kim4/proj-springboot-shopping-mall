package com.springboot.shoppingMall.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping(value = {"/web/index", "/", "/index"})
    public String webIndex(){

//        return "/web/index";
        return "/admin/index";
    }

    @GetMapping("/login")
    public String webLogin(){
        return "/admin/contents/member/login";
    }

    @GetMapping("/web/signup")
    public String webSignup(){
        return "/web/contents/member/registration";
    }

}
